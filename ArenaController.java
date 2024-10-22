package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Arena;
import fr.efrei.pokemon.services.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/arenas")
public class ArenaController {

    private final ArenaService service;

    @Autowired
    public ArenaController(ArenaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Arena>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arena> findById(@PathVariable Long id) {
        Arena arena = service.findById(id);
        if (arena == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(arena, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Arena arena) {
        service.save(arena);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Arena arena) {
        Arena arenaToUpdate = service.findById(id);
        if (arenaToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, arena);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Arena arena = service.findById(id);
        if (arena == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
