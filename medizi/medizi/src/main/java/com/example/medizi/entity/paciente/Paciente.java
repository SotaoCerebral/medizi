package com.example.medizi.entity.paciente;

import com.example.medizi.entity.endereco.Endereco;
import com.example.medizi.entity.medico.Medico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "paciente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ativo;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private String genero;
    private String dataNascimento;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "paciente_medico",
            joinColumns = @JoinColumn(name = "paciente_id"),
            inverseJoinColumns = @JoinColumn(name = "medico_id"))
    private List<Medico> medico;
    public Paciente(PacienteCreateDTO dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.rg = dto.rg();
        this.telefone = dto.telefone();
        this.email = dto.email();
        this.genero = dto.genero();
        this.dataNascimento = dto.dataNascimento();
        this.endereco = new Endereco(dto.endereco());
        this.ativo = true;
    }
}
