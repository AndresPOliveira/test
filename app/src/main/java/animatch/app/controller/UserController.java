package animatch.app.controller;

import animatch.app.domain.AniUser;
import animatch.app.repository.UserRepository;
import jakarta.validation.Valid;
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

    @Autowired
    ListController listController;
    @GetMapping
    public ResponseEntity<List<AniUser>> getAll()
    {
        if (repository.findAll().isEmpty()){
            return ResponseEntity.status(204).build();
        }
        System.out.println(repository.findAll());
        return ResponseEntity.status(200).body(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<AniUser> register(@RequestBody @Valid AniUser u)
    {
        if(repository.existsByEmail(u.getEmail())){
            return ResponseEntity.status(409).build();
        }
        repository.save(u);
        listController.defaultList(u.getId());
        return ResponseEntity.status(201).body(u);
    }

    @PostMapping("/login")
    public ResponseEntity<AniUser> login(@RequestBody @Valid AniUser u )
    {
        if (repository.existsByEmail(u.getEmail()) && repository.existsByPassword(u.getPassword())){
            return ResponseEntity.status(200).body(u);
        }
        return ResponseEntity.status(400).build();
    }
}
