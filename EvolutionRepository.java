package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Evolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvolutionRepository extends JpaRepository<Evolution, String> {
}

