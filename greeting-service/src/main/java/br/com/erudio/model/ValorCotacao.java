package br.com.erudio.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ValorCotacao(@JsonProperty("value") List<DadosCotacao> dadosCotacoes) {
}
