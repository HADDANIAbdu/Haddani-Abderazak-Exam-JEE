package org.example.haddaniabderazakexamapp.repositories;

import org.example.haddaniabderazakexamapp.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {
}
