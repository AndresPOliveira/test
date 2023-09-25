package animatch.app.repository;

import animatch.app.domain. AniUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AniUser,Integer> {
}
