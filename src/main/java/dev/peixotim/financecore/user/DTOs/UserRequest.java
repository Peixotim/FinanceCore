package dev.peixotim.financecore.user.DTOs;

import dev.peixotim.financecore.user.Entity.UserType;
import lombok.Builder;

@Builder
public record UserRequest(String name, String email, String password, UserType userType){
}
