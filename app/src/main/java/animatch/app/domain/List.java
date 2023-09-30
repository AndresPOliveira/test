package animatch.app.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="LIST")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "list_id", nullable = false)
    private AniList aniList;

    public List() {
    }
    public List(int userId) {
        this.userId = userId;
    }
    public List(int userId, @NotNull String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

}
