package org.example.haddaniabderazakexamapp.mappers;

import org.example.haddaniabderazakexamapp.dtos.CreditImmobilierDTO;
import org.example.haddaniabderazakexamapp.dtos.CreditPersonnelDTO;
import org.example.haddaniabderazakexamapp.entities.CreditImmobilier;
import org.example.haddaniabderazakexamapp.entities.CreditPersonnel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreditMapper {

    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel cp) {
        CreditPersonnelDTO cpDTO = new CreditPersonnelDTO();
        BeanUtils.copyProperties(cp, cpDTO);
        return cpDTO;
    }
    public CreditPersonnel fromCreditPersonnelDTO(CreditPersonnelDTO cpDTO) {
        CreditPersonnel cp = new CreditPersonnel();
        BeanUtils.copyProperties(cpDTO, cp);
        return cp;
    }
    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier cp) {
        CreditImmobilierDTO cpDTO = new CreditImmobilierDTO();
        BeanUtils.copyProperties(cp, cpDTO);
        return cpDTO;
    }
    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO cpDTO) {
        CreditImmobilier cp = new CreditImmobilier();
        BeanUtils.copyProperties(cpDTO, cp);
        return cp;
    }
}
