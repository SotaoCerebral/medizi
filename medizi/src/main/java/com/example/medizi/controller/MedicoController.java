package com.example.medizi.controller;

import com.example.medizi.entity.dtos.MedicoDTO;
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

    @PostMapping("/create-medico")
    public ResponseEntity<Medico> create(@RequestBody MedicoDTO dto) {
        service.create(dto);
        return ResponseEntity.ok().build();
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
    public ResponseEntity<Medico> update(@PathVariable Long id, @RequestBody MedicoDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
}
