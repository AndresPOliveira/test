package animatch.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AniList {

    @Id
    private int id ;
    private int listId;
    private int animeId;
}
