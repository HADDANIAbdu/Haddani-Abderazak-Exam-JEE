package org.example.haddaniabderazakexamapp.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CP")
@Data @NoArgsConstructor  @AllArgsConstructor @Builder
public class CreditPersonnel extends Credit{
    private String motif;
}

