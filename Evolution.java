package fr.efrei.pokemon.models;

import jakarta.persistence.*;

@Entity
public class Evolution {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    private Pokemon evolution;

    @ManyToOne
    private Pokemon pokemon;

    private int level;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon getEvolution() {
        return evolution;
    }

    public void setEvolution(Pokemon evolution) {
        this.evolution = evolution;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
