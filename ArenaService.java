package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Arena;
import fr.efrei.pokemon.repositories.ArenaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaService {

    private final ArenaRepository arenaRepository;

    @Autowired
    public ArenaService(ArenaRepository arenaRepository) {
        this.arenaRepository = arenaRepository;
    }

    public List<Arena> findAll() {
        return arenaRepository.findAll();
    }

    public Arena findById(Long id) {
        return arenaRepository.findById(String.valueOf(id)).orElse(null);
    }

    public void save(Arena arena) {
        arenaRepository.save(arena);
    }

    public void update(Long id, Arena updatedArena) {
        Arena existingArena = findById(id);
        if (existingArena != null) {
            existingArena.setName(updatedArena.getName());
            existingArena.setTrainers(updatedArena.getTrainers());
            arenaRepository.save(existingArena);
        }
    }

    public void delete(Long id) {
        arenaRepository.deleteById(String.valueOf(id));
    }
}

