package animatch.app.controller;

import animatch.app.domain.AniUser;
import animatch.app.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/lists")
public class ListController {

    @Autowired
    ListRepository listRepository;

    public animatch.app.domain.List addList(int aniUserId, String name){
        animatch.app.domain.List l = new animatch.app.domain.List(aniUserId,name);
        listRepository.save(l);
        return l;
    }
    @PostMapping
    public ResponseEntity<List<animatch.app.domain.List>> defaultList(int aniUserId){

        animatch.app.domain.List f = new animatch.app.domain.List(aniUserId,"favorites");
        animatch.app.domain.List d = new animatch.app.domain.List(aniUserId,"dropped");
        animatch.app.domain.List w = new animatch.app.domain.List(aniUserId,"watched");
        animatch.app.domain.List o = new animatch.app.domain.List(aniUserId,"on going");


        listRepository.save(f);
        listRepository.save(d);
        listRepository.save(w);
        listRepository.save(o);
        return ResponseEntity.status(200).body(listRepository.findAllById(Collections.singleton(aniUserId)));
    }

    @PostMapping("/new")
    public  ResponseEntity<animatch.app.domain.List> newList(@RequestBody animatch.app.domain.List l){
        var response = addList(l.getUserId(),l.getName());
        return ResponseEntity.status(200).body(response);
    }
    @GetMapping
    public ResponseEntity<List<animatch.app.domain.List>> getLists(){
        if (listRepository.findAll().isEmpty()){
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.status(200).body(listRepository.findAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<animatch.app.domain.List>> getListsById(@PathVariable Integer userId){
        if (listRepository.findAllByUserId(userId).isEmpty()){
            return ResponseEntity.status(400).build();
        }
        return ResponseEntity.status(200).body(listRepository.findAllByUserId(userId));
    }
}