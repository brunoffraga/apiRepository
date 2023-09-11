package br.com.api.checkListlab.domain.regiao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoRegiao(
        
        @NotNull
        long id,

        @NotBlank
        String nome,

        @NotBlank
        String responsavel
        
) {

}
