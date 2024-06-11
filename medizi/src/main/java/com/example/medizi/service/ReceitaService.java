package com.example.medizi.service;

import com.example.medizi.entity.medico.Medico;
import com.example.medizi.entity.paciente.Paciente;
import com.example.medizi.entity.receita.Receita;
import com.example.medizi.entity.receita.ReceitaCreateDTO;
import com.example.medizi.entity.receita.ReceitaUpdateDTO;
import com.example.medizi.repository.MedicoRepository;
import com.example.medizi.repository.PacienteRepository;
import com.example.medizi.repository.ReceitaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {
    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Receita> ListarReceitas() {
        return this.receitaRepository.findAll();
    }

    public Receita criarReceita(ReceitaCreateDTO receitaCreateDTO) {
        Optional<Medico> medico = this.medicoRepository.findById(receitaCreateDTO.medicoId());
        Optional<Paciente> paciente = this.pacienteRepository.findById(receitaCreateDTO.pacienteId());
        Receita receita = new Receita(medico.get(), paciente.get(), receitaCreateDTO.remedios(), receitaCreateDTO.frequencia(), receitaCreateDTO.assinaturaMedico());

        this.receitaRepository.save(receita);

        return receita;
    }

    public Receita atualizarReceita(ReceitaUpdateDTO receitaUpdateDTO, Long id) {
        Optional<Receita> receita = this.receitaRepository.findById(id);
        BeanUtils.copyProperties(receitaUpdateDTO, receita.get());
        this.receitaRepository.save(receita.get());

        return receita.get();
    }

    public void deletarReceita(Long id) {
        Optional<Receita> receita = this.receitaRepository.findById(id);

        this.receitaRepository.delete(receita.get());
    }
}
