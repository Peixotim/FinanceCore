package dev.peixotim.financecore.user.Service;

import dev.peixotim.financecore.user.DTOs.UserRequest;
import dev.peixotim.financecore.user.DTOs.UserResponse;
import dev.peixotim.financecore.user.Mapper.UserMapper;
import dev.peixotim.financecore.user.Mapper.UserRequestResponseMapper;
import dev.peixotim.financecore.user.Repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
        var requestFromDTO = mapperRes.toUsers(request);
        var dtoFromModel = mapper.toModel(requestFromDTO);
        var getPassword = dtoFromModel.getPassword();
        var transform = encoder.encode(getPassword);
        dtoFromModel.setPassword(transform);

        repository.save(dtoFromModel);

        var res = mapperRes.toResponse(requestFromDTO);

        return res;
    }
}
