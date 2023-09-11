package br.com.api.checkListlab.domain.checkList;

import br.com.api.checkListlab.domain.check.Check;
import br.com.api.checkListlab.domain.checkListAdicional.CheckListAdicional;
import br.com.api.checkListlab.domain.cliente.Cliente;
import jakarta.validation.constraints.*;

public record DadosCadastroCheckList(

    @NotNull
    Long numeroChamado,

    @NotBlank
    String usuarioFazendo,

    @NotNull
    Cliente cliente,

    @NotNull
    Check check,

    @NotNull
    CheckListAdicional checkListAdicional
    
    ) {
    
}
