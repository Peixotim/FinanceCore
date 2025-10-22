package dev.peixotim.financecore.user.DTOs;

import dev.peixotim.financecore.user.Model.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private UserType userType;
}
