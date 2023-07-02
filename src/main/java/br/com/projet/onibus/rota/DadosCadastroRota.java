package br.com.projet.onibus.rota;

public record DadosCadastroRota(
        String linha,
        String cidade,

        String caixa,

        String valorpassagem,

        Origem origem,

        Origem destino,

        int quantidadepassageiros) {
}
