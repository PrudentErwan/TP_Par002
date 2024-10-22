package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Evolution;
import fr.efrei.pokemon.repositories.EvolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvolutionService {

    private final EvolutionRepository evolutionRepository;

    @Autowired
    public EvolutionService(EvolutionRepository evolutionRepository) {
        this.evolutionRepository = evolutionRepository;
    }


    public List<Evolution> findAll() {
        return evolutionRepository.findAll();
    }
    public Evolution findById(String id) {
        return evolutionRepository.findById(id).orElse(null);
    }
    public void save(Evolution evolution) {
        evolutionRepository.save(evolution);
    }
    public void update(String id, Evolution updatedEvolution) {
        Evolution existingEvolution = findById(id);
        if (existingEvolution != null) {
            existingEvolution.setPokemon(updatedEvolution.getPokemon());
            existingEvolution.setEvolution(updatedEvolution.getEvolution());
            existingEvolution.setLevel(updatedEvolution.getLevel());
            evolutionRepository.save(existingEvolution);


        }
    }
    public void delete(String id) {
        evolutionRepository.deleteById(id);
    }
}

