package br.com.api.checkListlab.domain.checkList;

import br.com.api.checkListlab.domain.check.Check;
import br.com.api.checkListlab.domain.checkListAdicional.CheckListAdicional;
import br.com.api.checkListlab.domain.cliente.Cliente;

public record DadosListagemCheckList(Long id, Long numeroChamado, String usuarioFazendo,
    Cliente cliente, Check check, CheckListAdicional checkListAdicional) {

        public DadosListagemCheckList(CheckList checkList){
            this(checkList.getId(), checkList.getNumeroChamado(), checkList.getUsuarioFazendo(),
                checkList.getCliente(), checkList.getCheck(), checkList.getCheckListAdicional());
        }
    
}