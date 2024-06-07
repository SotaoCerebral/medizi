package com.example.medizi.entity.paciente;

import com.example.medizi.entity.endereco.EnderecoCreateDTO;

public record PacienteCreateDTO(String nome, String cpf, String rg, String telefone, String email, String genero, String dataNascimento, EnderecoCreateDTO endereco) {
}
