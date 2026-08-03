package br.com.erudio.config;

import br.com.erudio.model.DadosCotacao;
import br.com.erudio.model.ValorCotacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CotacaoDeMoeda {

    @Autowired
    private RestClient restClient;

    @EventListener(ApplicationReadyEvent.class)
    public void run() throws Exception {

        LocalDate localDate = LocalDate.now();
        String dataFormat = localDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        ValorCotacao valorCotacao = restClient.get()
                .uri("https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoDolarDia(dataCotacao=@dataCotacao)?@dataCotacao='"
        + dataFormat +"'&$format=json").retrieve().body(ValorCotacao.class);

        if(valorCotacao != null && valorCotacao.dadosCotacoes() != null && !valorCotacao.dadosCotacoes().isEmpty()) {
            DadosCotacao dadosCotacao = valorCotacao.dadosCotacoes().getFirst();

            System.out.println(dadosCotacao);
        }
    }
}
