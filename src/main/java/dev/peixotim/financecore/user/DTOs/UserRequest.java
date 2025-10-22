package dev.peixotim.financecore.user.DTOs;

import dev.peixotim.financecore.user.Model.UserType;
import lombok.Builder;

@Builder
public record UserRequest(String name, String email, String password, UserType userType){
}
