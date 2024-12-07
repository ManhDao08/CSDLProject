package com.example.Spring.Example.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.Example.Models.Language;

public interface LanguageRepo extends JpaRepository<Language, Integer> {
    public List<Language> findByName(String name);
}
