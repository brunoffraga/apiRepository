package br.com.api.checkListlab.domain.checkList;

import br.com.api.checkListlab.domain.check.Check;
import br.com.api.checkListlab.domain.cliente.Cliente;
import br.com.api.checkListlab.domain.checkListAdicional.CheckListAdicional;

public record DadosDetalhamentoAtualizadoCheckList(Long numeroChamado, String usuarioFazendo,
    Cliente cliente, Check check, CheckListAdicional checkListAdicional) {

        public DadosDetalhamentoAtualizadoCheckList(CheckList checkList){
            this(checkList.getNumeroChamado(), checkList.getUsuarioFazendo(), checkList.getCliente(), 
            checkList.getCheck(), checkList.getCheckListAdicional());
        }
    
}
