package br.com.projet.onibus.onibus;

import br.com.projet.onibus.endereco.Endereco;
import br.com.projet.onibus.rota.DadosAtualizacaoRota;
import br.com.projet.onibus.rota.DadosCadastroRota;
import br.com.projet.onibus.rota.Rota;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name="onibus")
@Table(name="onibus")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Onibus {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String renavam;
    private String placa;
    private String fabricante;
    private String ano;
    private String capacidade;


    @ManyToOne
    @JoinColumn(name="rota_id", referencedColumnName = "id" , nullable=false)
    private Rota rota;

    private boolean viagem;


    public Onibus(DadosCadastroOnibus dados) {
        this.viagem = true;
        this.modelo = dados.modelo();
        this.renavam = dados.renavam();
        this.placa = dados.placa();
        this.fabricante = dados.fabricante();
        this.ano = dados.ano();
        this.capacidade = dados.capacidade();
    }

    public Onibus(DadosCadastroOnibus dados, Rota rota) {
        this.viagem = true;
        this.modelo = dados.modelo();
        this.renavam = dados.renavam();
        this.placa = dados.placa();
        this.fabricante = dados.fabricante();
        this.ano = dados.ano();
        this.capacidade = dados.capacidade();
        this.rota = rota;
    }

    public void atualizarInformacoes(DadosAtualizaOnibus dados, Rota rota) {
        if (dados.modelo() != null ) {
            this.modelo = dados.modelo();
        }
        if (dados.renavam() != null) {
            this.renavam = dados.renavam();
        }
        if (dados.placa() != null){
            this.placa = dados.placa();
        }

        if (dados.fabricante() != null ) {
            this.fabricante = dados.fabricante();
        }
        if (dados.ano() != null) {
            this.ano = dados.ano();
        }
        if (dados.capacidade() != null){
            this.capacidade = dados.capacidade();
        }
        if (rota != null){
            this.rota = rota;
        }
    }

    public void excluir() {
        this.viagem = false;
    }
}
