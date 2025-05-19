package org.example.haddaniabderazakexamapp.services;


import org.example.haddaniabderazakexamapp.dtos.CreditImmobilierDTO;
import org.example.haddaniabderazakexamapp.dtos.CreditPersonnelDTO;

public interface CreditService {
    public CreditPersonnelDTO createCreditPersonnel(CreditPersonnelDTO creditPersonnelDTO);
    public CreditPersonnelDTO getCreditPersonnel(Long id);
    public CreditPersonnelDTO updateCreditPersonnel(Long id, CreditPersonnelDTO creditPersonnelDTO);
    public void deleteCreditPersonnel(Long id);

    public CreditImmobilierDTO createCreditImmobilier(CreditImmobilierDTO creditImmobilierDTO);
    public CreditImmobilierDTO getCreditImmobilier(Long id);
    public CreditImmobilierDTO updateCreditImmobilier(Long id, CreditImmobilierDTO creditImmobilierDTO);
    public void deleteCreditImmobilier(Long id);
}
