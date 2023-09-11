package br.com.api.checkListlab.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.checkListlab.domain.regiao.*;

/*
 * feito: Bruno
 * 
 * Aqui controla a entrada e saida de dados.
 * Onde se comunica com o banco de dados.
 * Fazendo gets e sets.
 * 
 * @author Bruno Fraga
 */

@RestController
@RequestMapping("/regiao")
public class RegiaoController {

    @Autowired
    private RepositoryRegiao repository;

    //adicionar região no banco de dados
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroRegiao dados, UriComponentsBuilder uriComponentsBuilder){
        var regiao = new Regiao(dados);
        repository.save(regiao);

        var uri = uriComponentsBuilder.path("/regiao/{id}").buildAndExpand(regiao.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoRegiao(regiao));
    }

    //mostrando a lista de ativos
    @GetMapping
    public ResponseEntity<Page<DadosListagemRegiao>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(null).map(DadosListagemRegiao::new);
        System.out.println(page);
        return ResponseEntity.ok(page);
    }

    //mostrando lista de excluidos
    @GetMapping("/excluida")
    public ResponseEntity<Page<DadosListagemRegiao>> listarExcluidos(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoFalse(null).map(DadosListagemRegiao::new);
        System.out.println(page);
        return ResponseEntity.ok(page);
    }

    //atualizando a região
    @PutMapping
    @Transactional
    public void atualizacao(@RequestBody @Valid DadosAtualizacaoRegiao dados){
        var regiao = repository.getReferenceById(dados.id());
        regiao.atualizacaoInfomacaoRegiao(dados);
    }

    //dixando o usuario destivado
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var regiao = repository.getReferenceById(id);
        regiao.excluir(id);
        
        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoRegiao(regiao));
    }

    //deixando o usuario ativo
    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var regiao = repository.getReferenceById(id);
        regiao.ativar(id);
        
        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoRegiao(regiao));
    }

}