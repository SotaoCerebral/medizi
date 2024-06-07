package com.example.medizi.entity.medico;

import com.example.medizi.entity.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "medico")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ativo;
    private String nome;
    private String especialidade;
    private String crm;
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    public Medico(MedicoCreateDTO dto) {
        this.nome = dto.nome();
        this.especialidade = dto.especialidade();
        this.crm = dto.crm();
        this.email = dto.email();
        this.endereco = new Endereco(dto.endereco());
        this.ativo = true;
    }
}
