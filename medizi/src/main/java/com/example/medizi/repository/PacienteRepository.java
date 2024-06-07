package com.example.medizi.repository;

import com.example.medizi.entity.paciente.Paciente;
import com.example.medizi.service.PacienteService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Long> {

}
