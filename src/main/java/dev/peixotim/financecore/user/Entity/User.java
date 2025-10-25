package dev.peixotim.financecore.user.Entity;

import dev.peixotim.financecore.account.Entity.Account;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Valid
    @Column(name = "name",length = 255)
    private String name;

    @Email
    @Valid
    @NotBlank
    @Column(name = "email" , length = 140 , unique = true)
    private String email;

    @NotBlank
    @Column(name = "password",length = 64)
    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.DEFAULT;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Account account;
}
