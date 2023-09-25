package animatch.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import animatch.app.domain.List;

public interface ListRepository extends JpaRepository<List,Integer> {
}
