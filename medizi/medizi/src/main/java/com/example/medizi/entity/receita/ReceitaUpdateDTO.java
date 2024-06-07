package com.example.medizi.entity.receita;

import com.example.medizi.entity.medico.Medico;
import com.example.medizi.entity.paciente.Paciente;

import java.util.List;

public record ReceitaUpdateDTO(
        Medico medico,
        Paciente paciente,
        List<String> remedios,
        String frequencia,
        String assinaturaMedico
) {
}
