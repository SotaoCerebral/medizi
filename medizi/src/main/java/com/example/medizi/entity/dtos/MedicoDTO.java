package com.example.medizi.entity.dtos;

import com.example.medizi.entity.endereco.Endereco;

public record MedicoDTO(String nome, String especialidade, String crm, String email, EnderecoDTO endereco) {
}
