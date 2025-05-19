package org.example.haddaniabderazakexamapp.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.haddaniabderazakexamapp.enums.RemboursementType;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Remboursement {
    @Id
    private Long id;
    private Date date;
    private double montant;
    private RemboursementType type;

    @ManyToOne
    private Credit credit;
}
