package dev.peixotim.financecore.account.DTOs;


import lombok.Builder;
import java.util.UUID;
import java.math.BigDecimal;

@Builder
public record AccountRequest(
        UUID id,
        String account_number,
        BigDecimal balance,
        UUID userId
) {}

