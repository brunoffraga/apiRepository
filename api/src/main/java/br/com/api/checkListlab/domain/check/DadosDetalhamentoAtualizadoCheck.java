package br.com.api.checkListlab.domain.check;

public record DadosDetalhamentoAtualizadoCheck(Long id, String check) {
 
    public DadosDetalhamentoAtualizadoCheck(Check check){
        this(check.getId(), check.getChek());
    }
}