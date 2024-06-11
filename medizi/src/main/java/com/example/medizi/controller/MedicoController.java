package com.example.medizi.controller;

import com.example.medizi.entity.medico.MedicoCreateDTO;
import com.example.medizi.entity.medico.Medico;
import com.example.medizi.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    private MedicoService service;

    @PostMapping
    public ResponseEntity<Medico> create(@RequestBody MedicoCreateDTO dto) {
        return ResponseEntity.ok(this.service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Medico>> listUnit(@PathVariable Long id) {
        return ResponseEntity.ok(service.listUnit(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Medico> update(@PathVariable Long id, @RequestBody MedicoCreateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
