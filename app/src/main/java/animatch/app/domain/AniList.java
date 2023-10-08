package animatch.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
public class AniList {

    @Id
    private int id ;
    private int animeId;

    public int getId() {
        return id;
    }

    public int getAnimeId() {
        return animeId;
    }
}
