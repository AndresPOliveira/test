package animatch.app.controller;

import animatch.app.domain.AniUser;
import animatch.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/")
    public ResponseEntity<List<AniUser>> getAll()
    {
        if (repository.findAll().isEmpty()){
            return ResponseEntity.status(204).build();
        }
        System.out.println(repository.findAll());
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<AniUser> register(@RequestBody AniUser u)
    {
        repository.save(u);
        return ResponseEntity.status(201).body(u);
    }
}
