package br.com.projet.onibus.onibus;

import br.com.projet.onibus.rota.DadosCadastroRota;
import br.com.projet.onibus.rota.Rota;
import com.fasterxml.jackson.annotation.JacksonInject;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizaOnibus(@NotNull
                                   Long id,

                                   String modelo,
                                   String renavam,
                                   String placa,
                                   String fabricante,
                                   String ano,
                                   String capacidade,

                                  DadosCadastroRota rota
                                  ) {
}
