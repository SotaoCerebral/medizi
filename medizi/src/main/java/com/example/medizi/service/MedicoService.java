package com.example.medizi.service;

import com.example.medizi.entity.dtos.MedicoDTO;
import com.example.medizi.entity.dtos.PacienteDTO;
import com.example.medizi.entity.medico.Medico;
import com.example.medizi.repository.EnderecoRepository;
import com.example.medizi.repository.MedicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    public Medico create(MedicoDTO dto) {
        Medico medico = new Medico(dto);
        this.enderecoRepository.save(medico.getEndereco());
        return this.repository.save(medico);
    }

    public List<Medico> listAll() {
        return repository.findAll();
    }

    public Optional<Medico> listUnit(Long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        Optional<Medico> medico = repository.findById(id);
        medico.get().setAtivo(false);
        repository.save(medico.get());
    }

    public Medico update(Long id, MedicoDTO dto) {
        Optional<Medico> medico = repository.findById(id);
        BeanUtils.copyProperties(dto, medico.get());
        return repository.save(medico.get());
    }
}
