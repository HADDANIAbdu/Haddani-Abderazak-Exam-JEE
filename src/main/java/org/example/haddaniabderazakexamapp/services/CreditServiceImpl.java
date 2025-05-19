package org.example.haddaniabderazakexamapp.services;

import lombok.AllArgsConstructor;
import org.example.haddaniabderazakexamapp.dtos.CreditImmobilierDTO;
import org.example.haddaniabderazakexamapp.dtos.CreditPersonnelDTO;
import org.example.haddaniabderazakexamapp.entities.Client;
import org.example.haddaniabderazakexamapp.entities.Credit;
import org.example.haddaniabderazakexamapp.entities.CreditPersonnel;
import org.example.haddaniabderazakexamapp.mappers.CreditMapper;
import org.example.haddaniabderazakexamapp.repositories.ClientRepo;
import org.example.haddaniabderazakexamapp.repositories.CreditRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {

    private CreditMapper creditMapper;
    private CreditRepo creditRepo;
    private ClientRepo  clientRepo;

    @Override
    public List<Credit> getCredits() {
        return creditRepo.findAll();
    }

    @Override
    public CreditPersonnelDTO createCreditPersonnel(CreditPersonnelDTO creditPersonnelDTO) {
        Client client = clientRepo.findById(creditPersonnelDTO.getClientDTO().getId()).orElse(null);
        if (client == null) throw new RuntimeException("Client not found");
        CreditPersonnel creditPersonnel = creditMapper.fromCreditPersonnelDTO(creditPersonnelDTO);
        creditPersonnel.setClient(client);
        CreditPersonnel savedCreditPersonnel = creditRepo.save(creditPersonnel);
        return creditMapper.fromCreditPersonnel(savedCreditPersonnel);
    }

    @Override
    public CreditPersonnelDTO getCreditPersonnel(Long id) {
        CreditPersonnel creditPersonnel = (CreditPersonnel) creditRepo.findById(id).orElse(null);
        if (creditPersonnel == null) throw new RuntimeException("Credit personnel not found");
        return creditMapper.fromCreditPersonnel(creditPersonnel);
    }

    @Override
    public CreditPersonnelDTO updateCreditPersonnel(Long id, CreditPersonnelDTO creditPersonnelDTO) {
        Client client = clientRepo.findById(creditPersonnelDTO.getClientDTO().getId()).orElse(null);
        if (client == null) throw new RuntimeException("Client not found");
        CreditPersonnel savedCreditPersonnel = (CreditPersonnel) creditRepo.findById(id).orElse(null);
        if (savedCreditPersonnel == null) throw new RuntimeException("Credit personnel not found");
        savedCreditPersonnel.setMotif(creditPersonnelDTO.getMotif());
        savedCreditPersonnel.setStatus(creditPersonnelDTO.getStatus());
        savedCreditPersonnel.setInterestRate(creditPersonnelDTO.getInterestRate());
        savedCreditPersonnel.setMontant(creditPersonnelDTO.getMontant());
        savedCreditPersonnel.setDate_demande(creditPersonnelDTO.getDate_demande());
        savedCreditPersonnel.setClient(client);
        return creditMapper.fromCreditPersonnel(savedCreditPersonnel);
    }

    @Override
    public void deleteCreditPersonnel(Long id) {
        CreditPersonnel creditPersonnel = (CreditPersonnel) creditRepo.findById(id).orElse(null);
        if (creditPersonnel == null) throw new RuntimeException("Credit personnel not found");
        creditRepo.delete(creditPersonnel);
    }

    @Override
    public CreditImmobilierDTO createCreditImmobilier(CreditImmobilierDTO creditImmobilierDTO) {
        return null;
    }

    @Override
    public CreditImmobilierDTO getCreditImmobilier(Long id) {
        return null;
    }

    @Override
    public CreditImmobilierDTO updateCreditImmobilier(Long id, CreditImmobilierDTO creditImmobilierDTO) {
        return null;
    }

    @Override
    public void deleteCreditImmobilier(Long id) {

    }
}
