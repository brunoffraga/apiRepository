package br.com.api.checkListlab.domain.cliente;

public record DadosListagemCliente(long id, Long idTotalControl, String nomeCliente) {

    public DadosListagemCliente(Cliente cliente){
        this(cliente.getId(), cliente.getIdTotalControl(), cliente.getNomeCliente());
    }
    
}
