package br.com.projet.onibus.rota;

public record DadosDetalhamentoRota(Long id, String linha, Origem origem, Origem destino, int quantidadepassageiros) {

    public DadosDetalhamentoRota(Rota rota){
        this(rota.getId(), rota.getLinha(), rota.getOrigem(), rota.getDestino(), rota.getQuantidadepassageiros());
    }
}
