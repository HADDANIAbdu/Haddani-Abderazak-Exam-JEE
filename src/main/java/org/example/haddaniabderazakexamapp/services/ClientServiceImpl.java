package org.example.haddaniabderazakexamapp.services;

import lombok.AllArgsConstructor;
import org.example.haddaniabderazakexamapp.dtos.ClientDTO;
import org.example.haddaniabderazakexamapp.dtos.CreditImmobilierDTO;
import org.example.haddaniabderazakexamapp.dtos.CreditPersonnelDTO;
import org.example.haddaniabderazakexamapp.dtos.CreditProfessionnelDTO;
import org.example.haddaniabderazakexamapp.entities.Client;
import org.example.haddaniabderazakexamapp.entities.CreditPersonnel;
import org.example.haddaniabderazakexamapp.mappers.ClientMapper;
import org.example.haddaniabderazakexamapp.mappers.CreditMapper;
import org.example.haddaniabderazakexamapp.repositories.ClientRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepo clientRepo;
    private ClientMapper clientMapper;
    private CreditMapper creditMapper;

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepo.save(client);
        return clientMapper.fromClient(savedClient);
    }

    @Override
    public ClientDTO updateClient(Long clientId, ClientDTO clientDTO) {
        Client updateClient = clientRepo.findById(clientId).orElse(null);
        if (updateClient == null) throw new RuntimeException("Client not found");
        updateClient.setName(clientDTO.getName());
        updateClient.setEmail(clientDTO.getEmail());
        return clientMapper.fromClient(updateClient);
    }

    @Override
    public ClientDTO getClient(Long clientId) {
        Client client = clientRepo.findById(clientId).orElse(null);
        if(client == null) throw new RuntimeException("Client not found");
        return clientMapper.fromClient(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepo.findAll();
        List<ClientDTO> customerDTOS = clients.stream()
                .map(customer -> clientMapper.fromClient(customer))
                .collect(Collectors.toList());
        return customerDTOS;
    }

    @Override
    public void deleteClient(Long clientId) {
        Client client = clientRepo.findById(clientId).orElse(null);
        if(client == null) throw new RuntimeException("Client not found");
        clientRepo.delete(client);
    }

    @Override
    public List<CreditPersonnelDTO> getAllCreditPersonnels(Long clientId) {
        return List.of();
    }

    @Override
    public List<CreditImmobilierDTO> getAllCreditImmobiliers(Long clientId) {
        return List.of();
    }

    @Override
    public List<CreditProfessionnelDTO> getAllCreditProfessionnels(Long clientId) {
        return List.of();
    }
}
