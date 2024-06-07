package com.example.medizi.entity.dtos;

import com.example.medizi.entity.dtos.EnderecoDTO;

public record PacienteDTO(String nome, String cpf, String rg, String telefone, String email, String genero, String dataNascimento, EnderecoDTO endereco) {
}
