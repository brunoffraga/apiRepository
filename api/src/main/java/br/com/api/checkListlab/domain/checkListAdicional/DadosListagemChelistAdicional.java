package br.com.api.checkListlab.domain.checkListAdicional;

import br.com.api.checkListlab.domain.check.Check;

public record DadosListagemChelistAdicional(Long id, Check check) {
    
    public DadosListagemChelistAdicional(CheckListAdicional checkListAdicional){
        this(checkListAdicional.getId(), checkListAdicional.getCheck());
    }
}
