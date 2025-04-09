package com.example.CadastroMedico.service;

import com.example.CadastroMedico.entity.Medico;
import com.example.CadastroMedico.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;

    public List<Medico> findAll() {
        return repository.findAll();
    }

    public Medico findById(Long id) {
        Optional<Medico> obj = repository.findById(id);
        return obj.get();
    }

    public Medico insert(Medico obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Medico update(Long id, Medico obj) {
        Medico entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Medico entity, Medico obj) {
        entity.setNome(obj.getNome());
        entity.setCadastro(obj.getCadastro());
        entity.setTelefone(obj.getTelefone());
        entity.setStatus(obj.getStatus());
    }
}
