package org.example.haddaniabderazakexamapp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.haddaniabderazakexamapp.enums.RemboursementType;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Remboursement {
    @Id
    private Long id;
    private Date date;
    private double montant;
    @Enumerated(EnumType.STRING)
    private RemboursementType type;

    @ManyToOne
    private Credit credit;
}
