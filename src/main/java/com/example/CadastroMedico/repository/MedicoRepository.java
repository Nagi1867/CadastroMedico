package com.example.CadastroMedico.repository;

import com.example.CadastroMedico.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}
