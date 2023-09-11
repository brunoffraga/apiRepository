package br.com.api.checkListlab.domain.cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCliente (

    @NotNull
    Long id,

    @NotNull
    Long idTotalControl,

    @NotBlank
    String nomeCliente){

}
