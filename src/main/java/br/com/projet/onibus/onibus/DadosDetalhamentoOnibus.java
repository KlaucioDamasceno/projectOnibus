package br.com.projet.onibus.onibus;

import br.com.projet.onibus.rota.Rota;

public record DadosDetalhamentoOnibus(Long id, String modelo, String fabricante, String ano, int capacidade, Rota rota) {

    public DadosDetalhamentoOnibus(Onibus onibus){
        this(onibus.getId(), onibus.getModelo(), onibus.getFabricante(), onibus.getAno(), onibus.getCapacidade(), onibus.getRota());
    }
}
