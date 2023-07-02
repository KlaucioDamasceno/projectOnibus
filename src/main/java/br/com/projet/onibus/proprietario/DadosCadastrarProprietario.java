package br.com.projet.onibus.proprietario;
import br.com.projet.onibus.endereco.DadosEndereco;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarProprietario(
        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        String cpf,

        String telefone) {
}
