package org.example.haddaniabderazakexamapp.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CI")
@Data @NoArgsConstructor @AllArgsConstructor
public class CreditImmobilier extends Credit{
    private String bien_fiance;
}

