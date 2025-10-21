package dev.peixotim.financecore.User.Mapper;

import dev.peixotim.financecore.User.DTOs.UserDTO;
import dev.peixotim.financecore.User.Model.User;
import org.springframework.stereotype.Component;

@Component
public class Entity {

    public User toDto(UserDTO dto){
        User user = new User();
        user.setName();
        user.setEmail();
        user.setPassword();
    }
}
