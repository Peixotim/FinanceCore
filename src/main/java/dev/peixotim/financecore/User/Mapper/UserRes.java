package dev.peixotim.financecore.User.Mapper;

import dev.peixotim.financecore.User.DTOs.Request;
import dev.peixotim.financecore.User.DTOs.Response;
import dev.peixotim.financecore.User.DTOs.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRes {

    public UserDTO toUsers(Request request){
            var req =
                    UserDTO.builder()
                            .name(request.name())
                            .email(request.email())
                            .password(request.password())
                            .userType(request.userType())
                            .build();
            return req;
    }

    public Response toResponse(UserDTO dto){
        var response =
                Response.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                        .userType(dto.getUserType())
                        .build();
        return response;
    }

}
