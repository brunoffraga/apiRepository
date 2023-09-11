package br.com.api.checkListlab.domain.cliente;

public record DadosDetalhamentoAtualizadoCliente(Long idTotalControl, String nome) {

    public DadosDetalhamentoAtualizadoCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNomeCliente());
    }
    
}
