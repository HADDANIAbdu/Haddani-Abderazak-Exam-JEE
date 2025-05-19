package org.example.haddaniabderazakexamapp.dtos;

import lombok.Data;
import org.example.haddaniabderazakexamapp.enums.CreditStatus;

import java.util.Date;

@Data
public class CreditPersonnelDTO {
    private Long id;
    private Date date_demande;
    private CreditStatus status;
    private double montant;
    private double interestRate;
    private ClientDTO clientDTO;
    private String motif;
}
