package br.com.api.checkListlab.domain.check;

public record DadosListagemCheck(Long id, String check) {
    
    public DadosListagemCheck(Check check){
        this(check.getId(), check.getChek());
    }
}
