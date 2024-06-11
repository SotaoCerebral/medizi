package com.example.medizi.controller;

import com.example.medizi.entity.receita.Receita;
import com.example.medizi.entity.receita.ReceitaCreateDTO;
import com.example.medizi.entity.receita.ReceitaUpdateDTO;
import com.example.medizi.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public ResponseEntity<List<Receita>> listarReceitas() {
        return ResponseEntity.ok(this.receitaService.ListarReceitas());
    }

    @PostMapping
    public ResponseEntity<Receita> criarReceita(@RequestBody ReceitaCreateDTO receitaCreateDTO) {
        return ResponseEntity.ok(this.receitaService.criarReceita(receitaCreateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizarReceita(@RequestBody ReceitaUpdateDTO receitaUpdateDTO, @PathVariable Long id) {
        return ResponseEntity.ok(this.receitaService.atualizarReceita(receitaUpdateDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarReceita(@PathVariable Long id) {
        this.receitaService.deletarReceita(id);
        return ResponseEntity.noContent().build();
    }
}
