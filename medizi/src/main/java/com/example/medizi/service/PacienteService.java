package com.example.medizi.service;

import com.example.medizi.entity.dtos.MedicoDTO;
import com.example.medizi.entity.dtos.PacienteDTO;
import com.example.medizi.entity.medico.Medico;
import com.example.medizi.entity.paciente.Paciente;
import com.example.medizi.repository.EnderecoRepository;
import com.example.medizi.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Paciente create(PacienteDTO dto) {
        Paciente paciente = new Paciente(dto);
        this.enderecoRepository.save(paciente.getEndereco());
        return this.repository.save(paciente);
    }

    public List<Paciente> listAll(){
        return repository.findAll();
    }
    public Optional<Paciente> listUnit(Long id){
        return repository.findById(id);
}
    public void delete(Long id){
       Optional<Paciente> paciente = repository.findById(id);
        paciente.get().setAtivo(false);
        repository.save(paciente.get());
    }
    public Paciente update(Long id, PacienteDTO dto){
        Optional<Paciente> paciente = repository.findById(id);
        BeanUtils.copyProperties(dto,paciente.get());
        return repository.save(paciente.get());
    }

}
