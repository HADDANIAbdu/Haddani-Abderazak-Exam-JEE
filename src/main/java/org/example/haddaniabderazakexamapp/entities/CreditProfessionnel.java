package org.example.haddaniabderazakexamapp.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CP2")
@Data @NoArgsConstructor @AllArgsConstructor
public class CreditProfessionnel extends Credit{
    private String motif;
    private String raison_sociale;
}

