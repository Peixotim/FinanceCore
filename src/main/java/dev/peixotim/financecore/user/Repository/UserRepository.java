package dev.peixotim.financecore.User.Repository;
import dev.peixotim.financecore.User.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User,UUID> {
}
