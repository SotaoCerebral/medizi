package com.example.medizi.entity.medico;

import com.example.medizi.entity.endereco.EnderecoCreateDTO;

public record MedicoCreateDTO(String nome, String especialidade, String crm, String email, EnderecoCreateDTO endereco) {
}
