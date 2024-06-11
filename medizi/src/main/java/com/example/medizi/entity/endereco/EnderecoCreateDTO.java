package com.example.medizi.entity.endereco;

public record EnderecoCreateDTO(String cidade, String cep, String rua, Integer numero, String complemento, String bairro, String uf) {
}
