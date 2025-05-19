package org.example.haddaniabderazakexamapp.repositories;

import org.example.haddaniabderazakexamapp.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepo extends JpaRepository<Credit, Long> {
}
