package dev.peixotim.financecore.account.Entity;

import dev.peixotim.financecore.user.Entity.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_account")
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Valid
    @NotBlank
    @Column(name = "accountNumber",unique = true,nullable = false)
    private String account_number;

    @Valid
    @NotNull
    @Column(nullable = false, name = "balance",precision = 15 , scale = 2   )
    private BigDecimal balance = BigDecimal.valueOf(0);

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
