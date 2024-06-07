package com.example.medizi.controller;

import com.example.medizi.entity.dtos.PacienteDTO;
import com.example.medizi.entity.paciente.Paciente;
import com.example.medizi.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @PostMapping("create-paciente")
    public ResponseEntity<Paciente> create(@RequestBody PacienteDTO dto){
        service.create(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> listAll(){
        return ResponseEntity.ok(service.listAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Optional<Paciente>> listUnit(@PathVariable Long id){
        return ResponseEntity.ok(service.listUnit(id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
        public ResponseEntity<Paciente> update(@PathVariable Long id, @RequestBody PacienteDTO dto){
        return ResponseEntity.ok(service.update(id,dto));
    }
}
