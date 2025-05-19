package org.example.haddaniabderazakexamapp.services;


import org.example.haddaniabderazakexamapp.dtos.ClientDTO;
import org.example.haddaniabderazakexamapp.dtos.CreditImmobilierDTO;
import org.example.haddaniabderazakexamapp.dtos.CreditPersonnelDTO;
import org.example.haddaniabderazakexamapp.dtos.CreditProfessionnelDTO;

import java.util.List;

public interface ClientService {
    public ClientDTO createClient(ClientDTO clientDTO);
    public ClientDTO updateClient(Long clientId, ClientDTO clientDTO);
    public ClientDTO getClient(Long clientId);
    public List<ClientDTO> getAllClients();
    public void deleteClient(Long clientId);
    public List<CreditPersonnelDTO> getAllCreditPersonnels(Long clientId);
    public List<CreditImmobilierDTO> getAllCreditImmobiliers(Long clientId);
    public List<CreditProfessionnelDTO> getAllCreditProfessionnels(Long clientId);
}
