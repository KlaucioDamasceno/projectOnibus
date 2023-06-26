package br.com.projet.onibus.rota;

import br.com.projet.onibus.onibus.Onibus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity(name="rotas")
@Table(name="rotas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Rota {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String linha;
    private String cidade;

    private String valor_passagem;

    private String caixa;

    @Enumerated(EnumType.STRING)
    private Origem origem;

    @Enumerated(EnumType.STRING)
    private Origem destino;

    private boolean viagem;

    private int quantidade_passageiros;

    public Rota(DadosCadastroRota dados) {
        this.viagem = true;
        this.linha = dados.linha();
        this.cidade = dados.cidade();
        this.valor_passagem = dados.valor_passagem();
        this.caixa = dados.caixa();
        this.origem = dados.origem();
        this.destino = dados.destino();
        this.quantidade_passageiros = dados.quantidade_passageiros();
    }

    public void atualizarInformacoes(DadosAtualizacaoRota dados) {
       this.quantidade_passageiros = dados.quantidade_passageiros() > 0 ? dados.quantidade_passageiros() : getQuantidade_passageiros();
    }

    public void delete() {
        this.viagem = false;
    }
}
