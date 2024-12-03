package com.example.Spring.Example.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "film_actor")
public class FilmActor {

    @Id
    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @Id
    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    public FilmActor() {
    }

    public FilmActor(Actor actor, Film film) {
        this.actor = actor;
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmActor filmActor = (FilmActor) o;
        return actor.equals(filmActor.actor) &&
                film.equals(filmActor.film);
    }

    @Override
    public int hashCode() {
        return 31 * actor.hashCode() + film.hashCode();
    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "actor=" + actor +
                ", film=" + film +
                '}';
    }
}
