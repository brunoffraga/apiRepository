package br.com.api.checkListlab.domain.checkListAdicional;

import br.com.api.checkListlab.domain.check.Check;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroChelistAdicional(

    @NotNull
    Check check) {
    
}
