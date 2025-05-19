package org.example.haddaniabderazakexamapp.controllers;

import lombok.AllArgsConstructor;
import org.example.haddaniabderazakexamapp.dtos.CreditPersonnelDTO;
import org.example.haddaniabderazakexamapp.entities.Credit;
import org.example.haddaniabderazakexamapp.services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/credits")
@AllArgsConstructor
public class CreditController {
    private CreditService creditService;

    @GetMapping("/")
    public List<Credit> getAllCredits() {
        return creditService.getCredits();
    }

    @GetMapping("/personnel/{Id}")
    public CreditPersonnelDTO getCreditPersonnel(@PathVariable Long Id) {
        return creditService.getCreditPersonnel(Id);
    }
    @PostMapping("/create/personnel")
    public Map<String, String> createCredit(@RequestBody CreditPersonnelDTO personnelDTO) {
        creditService.createCreditPersonnel(personnelDTO);
        return Map.of("message", "Credit created");
    }

    @PutMapping("/update/personnel/{Id}")
    public Map<String, String> updateCredit(@PathVariable Long Id, @RequestBody CreditPersonnelDTO personnelDTO) {
        creditService.updateCreditPersonnel(Id, personnelDTO);
        return Map.of("message", "Credit updated");
    }

    @DeleteMapping("/delete/personnel/{Id}")
    public Map<String, String> deleteCredit(@PathVariable Long Id) {
        creditService.deleteCreditPersonnel(Id);
        return Map.of("message", "Credit deleted");
    }
}
