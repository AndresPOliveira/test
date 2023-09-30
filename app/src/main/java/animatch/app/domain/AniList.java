package animatch.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "ANILIST")
public class AniList {

    @Id
    private int id ;
    @OneToMany(mappedBy = "anilist")
    private Set<List> lists;
    private int animeId;

    public int getId() {
        return id;
    }

    public Set<List> getLists() {
        return lists;
    }

    public int getAnimeId() {
        return animeId;
    }
}
