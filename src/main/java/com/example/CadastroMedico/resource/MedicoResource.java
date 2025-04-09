package com.example.CadastroMedico.resource;

import com.example.CadastroMedico.entity.Medico;
import com.example.CadastroMedico.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoResource {
    @Autowired
    private MedicoService service;

    @GetMapping
    public ResponseEntity<List<Medico>> findAll() {
        List<Medico> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Medico> findById(@PathVariable Long id) {
        Medico obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Medico> insert(@RequestBody Medico obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Medico> update(@PathVariable Long id, @RequestBody Medico obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
