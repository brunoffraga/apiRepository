package br.com.api.checkListlab.domain.regiao;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroRegiao(
    
        @NotBlank
        String nome,
        
        @NotBlank
        String responsavel) {

}
