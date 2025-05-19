package org.example.haddaniabderazakexamapp;

import org.example.haddaniabderazakexamapp.entities.Client;
import org.example.haddaniabderazakexamapp.entities.CreditImmobilier;
import org.example.haddaniabderazakexamapp.entities.CreditPersonnel;
import org.example.haddaniabderazakexamapp.enums.CreditStatus;
import org.example.haddaniabderazakexamapp.repositories.ClientRepo;
import org.example.haddaniabderazakexamapp.repositories.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class HaddaniAbderazakExamAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaddaniAbderazakExamAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CreditRepo creditRepo,
                                        ClientRepo clientRepo) {
        return args -> {
            clientRepo.save(Client.builder()
                    .name("Abdo")
                    .email("abdo@gmail.com")
                    .build());
            clientRepo.save(Client.builder()
                    .name("ilyas")
                    .email("ilyas@gmail.com")
                    .build());
            Client client = Client.builder()
                    .name("oualid")
                    .email("oualid@gmail.com")
                    .build();
            clientRepo.save(client);
            CreditPersonnel creditPersonnel = new CreditPersonnel();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2027-06-19 08:30:00";
            creditPersonnel.setDate_demande(new Date());
            creditPersonnel.setDate_acceptation(dateFormat.parse(dateString));
            creditPersonnel.setDuree("1 year");
            creditPersonnel.setMontant(9000.00);
            creditPersonnel.setClient(client);
            creditPersonnel.setInterestRate(77.78);
            creditPersonnel.setStatus(CreditStatus.ACCEPTE);
            creditPersonnel.setMotif("achat de voiture");
            CreditImmobilier cImmobilier = new CreditImmobilier();
            String dateString2 = "2025-06-19 14:30:00";
            cImmobilier.setDate_demande(new Date());
            cImmobilier.setDate_acceptation(dateFormat.parse(dateString2));
            cImmobilier.setDuree("1 month");
            cImmobilier.setMontant(9000.00);
            cImmobilier.setClient(client);
            cImmobilier.setInterestRate(89.90);
            cImmobilier.setStatus(CreditStatus.ENCOURS);
            cImmobilier.setBien_fiance("Appartement");
            creditRepo.save(cImmobilier);



        };
    }
}
