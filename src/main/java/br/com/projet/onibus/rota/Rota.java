package br.com.projet.onibus.rota;

import br.com.projet.onibus.onibus.Onibus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    private String valorpassagem;

    private String caixa;

    @Enumerated(EnumType.STRING)
    private Origem origem;

    @Enumerated(EnumType.STRING)
    private Origem destino;

    private boolean viagem;

    private int quantidadepassageiros;

    @OneToMany
    private List<Onibus> onibus;

    public Rota(DadosCadastroRota dados) {
        this.viagem = true;
        this.linha = dados.linha();
        this.cidade = dados.cidade();
        this.valorpassagem = dados.valorpassagem();
        this.caixa = dados.caixa();
        this.origem = dados.origem();
        this.destino = dados.destino();
        this.quantidadepassageiros = dados.quantidadepassageiros();
        this.onibus = new ArrayList<>();
    }

    public void atualizarInformacoes(DadosAtualizacaoRota dados) {
       this.quantidadepassageiros = dados.quantidadepassageiros() > 0 ? dados.quantidadepassageiros() : getQuantidadepassageiros();

        if (dados.linha() != null ) {
            this.linha = dados.linha();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.valorpassagem() != null){
            this.valorpassagem = dados.valorpassagem();
        }
        if (dados.caixa() != null){
            this.caixa = dados.caixa();
        }

        if (dados.origem() != null){
            this.origem = dados.origem();
        }
        if (dados.destino() != null){
            this.destino = dados.destino();
        }
    }

    public void delete() {
        this.viagem = false;
    }

}
