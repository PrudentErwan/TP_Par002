package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArenaRepository extends JpaRepository<Arena, String> {
}

