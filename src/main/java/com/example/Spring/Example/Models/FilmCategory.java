package com.example.Spring.Example.Models;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    @Id
    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Constructors
    public FilmCategory() {}

    public FilmCategory(Film film, Category category) {
        this.film = film;
        this.category = category;
    }

    // Getters and Setters
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmCategory that = (FilmCategory) o;
        return Objects.equals(film, that.film) &&
               Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(film, category);
    }

    // toString
    @Override
    public String toString() {
        return "FilmCategory{" +
                "film=" + film +
                ", category=" + category +
                '}';
    }
}
