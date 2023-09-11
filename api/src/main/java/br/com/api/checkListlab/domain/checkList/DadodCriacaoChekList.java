package br.com.api.checkListlab.domain.checkList;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadodCriacaoChekList(

    @NotNull
    Long idNumeroChamado,

    @NotBlank
    String usuarioFazendo,

    @NotNull
    Long idCheck,

    @NotNull
    Long idCliente,

    @NotNull
    Long checkListAdicional

) {

}
