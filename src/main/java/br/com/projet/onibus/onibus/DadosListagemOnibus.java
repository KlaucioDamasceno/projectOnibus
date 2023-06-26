package br.com.projet.onibus.onibus;


import br.com.projet.onibus.rota.DadosDetalhamentoRota;

public record DadosListagemOnibus(Long id, String modelo, String fabricante, String ano, int capacidade, DadosDetalhamentoRota rota) {

    public DadosListagemOnibus(Onibus onibus){
        this(onibus.getId(), onibus.getModelo(), onibus.getFabricante(), onibus.getAno(), onibus.getCapacidade(), new DadosDetalhamentoRota(onibus.getRota()));
    }

}
