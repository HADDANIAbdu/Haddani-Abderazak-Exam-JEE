package org.example.haddaniabderazakexamapp.dtos;


import lombok.Data;
import org.example.haddaniabderazakexamapp.entities.Credit;
import org.example.haddaniabderazakexamapp.enums.RemboursementType;

import java.util.Date;

@Data
public class RemboursementDTO {
    private Long id;
    private Date date;
    private double montant;
    private RemboursementType type;
}
