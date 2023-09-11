package br.com.api.checkListlab.domain.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(

    @NotNull
    Long id,

    @NotNull
    Long idTotalControl,

    @NotBlank
    String nomeCliente) {

}
