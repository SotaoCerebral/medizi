package com.example.medizi.entity.receita;

import com.example.medizi.entity.medico.Medico;
import com.example.medizi.entity.paciente.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "receitas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ElementCollection
    @CollectionTable(name = "lista_remedios", joinColumns = @JoinColumn(name = "receita_id"))
    @Column(name = "remedio")
    private List<String> remedios;

    private String frequencia;

    private String assinaturaMedico;

    public Receita(ReceitaCreateDTO dto) {
        this.medico = dto.medico();
        this.paciente = dto.paciente();
        this.remedios = dto.remedios();
        this.frequencia = dto.frequencia();
        this.assinaturaMedico = dto.assinaturaMedico();
    }
}
