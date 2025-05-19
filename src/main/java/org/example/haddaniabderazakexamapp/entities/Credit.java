package org.example.haddaniabderazakexamapp.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.haddaniabderazakexamapp.enums.CreditStatus;

import java.util.Date;
import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type", length = 4)
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date_demande;
    private CreditStatus status;
    private Date date_acceptation;
    private double montant;
    private String duree;
    private double interestRate;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}

