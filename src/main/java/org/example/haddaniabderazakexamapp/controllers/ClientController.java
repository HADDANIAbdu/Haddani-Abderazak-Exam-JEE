package org.example.haddaniabderazakexamapp.controllers;

import lombok.AllArgsConstructor;
import org.example.haddaniabderazakexamapp.dtos.ClientDTO;
import org.example.haddaniabderazakexamapp.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/clients")
public class ClientController {
    private ClientService clientService;

    @GetMapping("/")
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/create")
    public Map<String,String> createClient(@RequestBody ClientDTO clientDTO) {
        clientService.createClient(clientDTO);
        return Map.of("message", "Client created");
    }

    @PutMapping("/update/{Id}")
    public Map<String,String> updateClient(@PathVariable Long Id, @RequestBody ClientDTO clientDTO) {
        clientService.updateClient(Id, clientDTO);
        return Map.of("message", "Client updated");
    }

    @GetMapping("/{Id}")
    public ClientDTO getClient(@PathVariable Long Id) {
        return clientService.getClient(Id);
    }

    @DeleteMapping("/delete/{Id}")
    public Map<String,String> deleteClient(@PathVariable Long Id) {
        clientService.deleteClient(Id);
        return Map.of("message", "Client deleted");
    }
}
