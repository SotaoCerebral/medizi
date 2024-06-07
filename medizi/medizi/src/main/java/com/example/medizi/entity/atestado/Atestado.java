package com.example.medizi.entity.atestado;

import com.example.medizi.entity.medico.Medico;
import com.example.medizi.entity.paciente.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "atestados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Atestado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private String dataConsulta;

    private String diagnostico;

    private String dataInicioAfastamento;

    private String dataRetornoAfastamento;

    private String assinaturaMedico;
}
