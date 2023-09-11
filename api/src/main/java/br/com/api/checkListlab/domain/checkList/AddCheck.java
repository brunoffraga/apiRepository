package br.com.api.checkListlab.domain.checkList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.checkListlab.domain.ValidacaoException;
import br.com.api.checkListlab.domain.check.RepositoryCheck;
import br.com.api.checkListlab.domain.checkListAdicional.RepositoryChelistAdicional;
import br.com.api.checkListlab.domain.cliente.RepositoryCliente;

@Service
public class AddCheck {

    @Autowired
    private RepositoryCheck repositoryCheck;
    
    @Autowired
    private RepositoryCliente repositoryCliente;
    
    @Autowired
    private RepositoryChelistAdicional repositoryCheckListAdicional;

    @Autowired
    private RepositoryCheckList repositoryCheckList;


    public DadosDetalhamentoAtualizadoCheckList cadastrais(DadodCriacaoChekList dados){

        if(!repositoryCheck.existsById(dados.idCliente())){
            throw new ValidacaoException("Id do paciente informado não existe!");
        }

        if(!repositoryCliente.existsById(dados.idCliente())){
            throw new ValidacaoException("Id do paciente informado não existe!");
        }

        var check = repositoryCheck.getReferenceById(dados.idCheck());
        var cliente = repositoryCliente.getReferenceById(dados.idCliente());
        var listaAdicional = repositoryCheckListAdicional.getReferenceById(dados.checkListAdicional());

        var cadastro = new CheckList(null, dados.idNumeroChamado(), true, dados.usuarioFazendo(), check, cliente, listaAdicional);
        repositoryCheckList.save(cadastro);

        return new DadosDetalhamentoAtualizadoCheckList(cadastro);
    }
    
}
