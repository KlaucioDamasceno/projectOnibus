package br.com.projet.onibus.onibus;

import br.com.projet.onibus.rota.Rota;

public record DadosCadastroOnibus(
         String modelo,
         String renavam,
         String placa,
         String fabricante,
         String ano,
         int capacidade,

         Rota rota

) {
}
