package dev.peixotim.financecore.account.DTOs;

import dev.peixotim.financecore.user.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private UUID id;
    private String account_number;
    private BigDecimal balance;
    private User user;

}
