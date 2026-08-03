package br.com.erudio.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record DadosCotacao(@JsonProperty("cotacaoCompra") BigDecimal cotacaoCompra,
                           @JsonProperty("cotacaoVenda") BigDecimal cotacaoVenda,
                           @JsonProperty("dataHoraCotacao") String dataHoraCotacao) {}
