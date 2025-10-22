package dev.peixotim.financecore.user.Mapper;

import dev.peixotim.financecore.user.DTOs.UserRequest;
import dev.peixotim.financecore.user.DTOs.UserResponse;
import dev.peixotim.financecore.user.DTOs.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRequestResponseMapper {

    public UserDTO toUsers(UserRequest userRequest){
            var req =
                    UserDTO.builder()
                            .name(userRequest.name())
                            .email(userRequest.email())
                            .password(userRequest.password())
                            .userType(userRequest.userType())
                            .build();
            return req;
    }

    public UserResponse toResponse(UserDTO dto){
        var response =
                UserResponse.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .userType(dto.getUserType())
                        .build();
        return response;
    }

}
