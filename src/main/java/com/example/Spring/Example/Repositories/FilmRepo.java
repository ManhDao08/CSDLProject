package com.example.Spring.Example.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.Example.Models.Film;

public interface FilmRepo extends JpaRepository<Film, Long> {
    
}
