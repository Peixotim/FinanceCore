package dev.peixotim.financecore.User.DTOs;

import dev.peixotim.financecore.User.Model.UserType;
import lombok.Builder;

@Builder
public record Request(String name, String email, String password, UserType userType){
}
