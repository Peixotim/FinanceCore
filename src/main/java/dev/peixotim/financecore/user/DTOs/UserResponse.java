package dev.peixotim.financecore.user.DTOs;

import dev.peixotim.financecore.user.Model.UserType;
import lombok.Builder;
import java.util.UUID;

@Builder
public record UserResponse(UUID id, String name, String email, UserType userType){
}
