package dev.peixotim.financecore.user.Repository;
import dev.peixotim.financecore.user.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,UUID> {

    boolean existsById(UUID id);
    Optional<User> findByName(String name);
}
