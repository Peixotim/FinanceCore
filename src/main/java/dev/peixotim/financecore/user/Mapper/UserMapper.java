package dev.peixotim.financecore.user.Mapper;

import dev.peixotim.financecore.user.DTOs.UserDTO;
import dev.peixotim.financecore.user.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //Passa um dto e retorna um model
    public User toModel(UserDTO dto){
        User user = User
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .userType(dto.getUserType())
                .build();

        return user;
    }

    //Passa um userDTO e retorna um user
    public UserDTO toDTO(User user){
        UserDTO dto = UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .userType(user.getUserType())
                .build();

        return dto;
    }
}
