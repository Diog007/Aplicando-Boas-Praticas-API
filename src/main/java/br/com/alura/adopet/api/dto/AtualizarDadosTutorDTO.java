package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Adocao;

import java.util.List;

public record AtualizarDadosTutorDTO(Long id, String nome, String telefone, String email, List<Adocao> adocoes) {
}
