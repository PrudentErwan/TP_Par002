package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Evolution;
import fr.efrei.pokemon.services.EvolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evolutions")
public class EvolutionController {

    private final EvolutionService service;

    @Autowired
    public EvolutionController(EvolutionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Evolution>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evolution> findById(@PathVariable String id) {
        Evolution evolution = service.findById(id);
        if (evolution == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(evolution, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Evolution evolution) {
        service.save(evolution);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Evolution evolution) {
        Evolution evolutionToUpdate = service.findById(id);
        if (evolutionToUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, evolution);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Evolution evolution = service.findById(id);
        if (evolution == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

