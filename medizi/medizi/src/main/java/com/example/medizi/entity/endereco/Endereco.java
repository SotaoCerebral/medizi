package com.example.medizi.entity.endereco;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "endereco")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cidade;
    private String cep;
    @Column(unique = true)
    private String rua;
    @Column(unique = true)
    private Integer numero;
    private String complemento;
    private String bairro;
    private String uf;



    public Endereco(EnderecoCreateDTO enderecoDTO) {
        this.cidade = enderecoDTO.cidade();
        this.cep = enderecoDTO.cep();
        this.rua = enderecoDTO.rua();
        this.numero = enderecoDTO.numero();
        this.complemento = enderecoDTO.complemento();
        this.bairro = enderecoDTO.bairro();
        this.uf = enderecoDTO.uf();
    }

}
