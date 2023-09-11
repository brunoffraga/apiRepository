package br.com.api.checkListlab.domain.check;

import jakarta.validation.constraints.*;

public record DadosAtualizacaoCadastroCheck(

    @NotNull
    Long id,

    @NotBlank
    String chek
    
) {
    
}
