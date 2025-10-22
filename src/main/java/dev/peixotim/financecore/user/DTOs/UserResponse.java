package dev.peixotim.financecore.User.DTOs;

import dev.peixotim.financecore.User.Model.UserType;
import lombok.Builder;
import java.util.UUID;

@Builder
public record Response(UUID id,String name, String email,UserType userType){
}
