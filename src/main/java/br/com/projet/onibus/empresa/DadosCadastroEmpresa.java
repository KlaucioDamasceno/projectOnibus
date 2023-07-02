package br.com.projet.onibus.empresa;

import br.com.projet.onibus.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEmpresa(
        @NotBlank
        String nome_fantasia,

        @NotBlank
        String email,

        @NotBlank
        String cnpj,

        @NotBlank
        String telefone
        ) {
}
