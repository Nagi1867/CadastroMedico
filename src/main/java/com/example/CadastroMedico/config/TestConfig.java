package com.example.CadastroMedico.config;

import com.example.CadastroMedico.entity.Medico;
import com.example.CadastroMedico.enums.Status;
import com.example.CadastroMedico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private MedicoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Medico medico = new Medico(null, "Ricardo", "2345234", "179923344433", Status.ATIVO);

        repository.save(medico);
    }
}
