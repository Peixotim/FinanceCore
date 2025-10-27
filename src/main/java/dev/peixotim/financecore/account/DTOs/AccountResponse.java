package dev.peixotim.financecore.account.DTOs;

import dev.peixotim.financecore.user.Entity.User;
import lombok.Builder;
import java.util.UUID;
import java.math.BigDecimal;

@Builder
public record AccountResponse(
        UUID id,
        String account_number,
        BigDecimal balance,
        UUID userId,
        String userName,
        String userEmail
) {}

