package animatch.app.repository;

import animatch.app.domain.AniList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AniListRepository extends JpaRepository<AniList,Integer> {
}
