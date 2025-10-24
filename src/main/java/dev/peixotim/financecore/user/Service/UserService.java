package dev.peixotim.financecore.user.Service;

import dev.peixotim.financecore.exceptions.custom.ResourceNotFoundException;
import dev.peixotim.financecore.user.DTOs.UserRequest;
import dev.peixotim.financecore.user.DTOs.UserResponse;
import dev.peixotim.financecore.user.Mapper.UserMapper;
import dev.peixotim.financecore.user.Mapper.UserRequestResponseMapper;
import dev.peixotim.financecore.user.Model.UserType;
import dev.peixotim.financecore.user.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository repository;
    private UserMapper mapper;
    private UserRequestResponseMapper mapperRes;
    private BCryptPasswordEncoder encoder;

    public UserService(UserRepository repository , UserMapper mapper, UserRequestResponseMapper mapperRes, BCryptPasswordEncoder encoder){
        this.repository = repository;
        this.mapper = mapper;
        this.mapperRes = mapperRes;
        this.encoder = encoder;
    }


    public UserResponse create(UserRequest request){

        var newUser = mapperRes.toUsers(request);

        String encodedPassword = encoder.encode(request.password());
        newUser.setPassword(encodedPassword);

        var model = mapper.toModel(newUser);
        repository.save(model);

        UserResponse response = mapperRes.toResponse(newUser);


        return response;
    }

    public UserResponse delete(UUID id){

        var model = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found !"));
        var modelToDTO = mapper.toDTO(model);
        var response = mapperRes.toResponse(modelToDTO);

        repository.delete(model);

        return response;

    }

    public UserResponse deleteByName(String name){
        var model = repository.findByName(name).orElseThrow(() -> new ResourceNotFoundException("User Not Found !"));
        repository.delete(model);

        var modelToDTO = mapper.toDTO(model);
        var response = mapperRes.toResponse(modelToDTO);

        return response;
    }


    public List<UserResponse> findAll(){
        var findAll = repository.findAll();

        if(findAll.isEmpty()){
            throw new ResourceNotFoundException("No user found in our database !");
        }
        return findAll.stream()
                .map(mapper :: toDTO)
                .map(mapperRes :: toResponse)
                .toList();

    }

    public UserResponse modifyUserType(String email , UserType type){
        var find = repository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("We were unable to find any user with this email in our database"));
        find.setUserType(type);
        repository.save(find);
        var toDTO = mapper.toDTO(find);
        var response = mapperRes.toResponse(toDTO);

        return response;

    }
}
