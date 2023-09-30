package animatch.app.repository;

import animatch.app.domain. AniUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AniUser,Integer> {
    public boolean existsByEmail(String email);
    public boolean existsByPassword(String password);
}
