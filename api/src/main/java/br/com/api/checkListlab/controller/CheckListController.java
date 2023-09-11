package br.com.api.checkListlab.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.checkListlab.domain.checkList.*;

@RestController
@RequestMapping("/CheckList")
public class CheckListController {
/* 
    @Autowired
    private RepositoryCheckList repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroCheckList dados, UriComponentsBuilder uriComponentsBuilder){
        var checkList = new CheckList(dados);

        var uri = uriComponentsBuilder.path("/check/{id}").buildAndExpand(checkList.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoCheckList(checkList));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCheckList>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(null).map(DadosListagemCheckList::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/listaEx")
    public ResponseEntity<Page<DadosListagemCheckList>> listaExcluir(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoFalse(null).map(DadosListagemCheckList::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public void atualizacao(@RequestBody @Valid DadosAtualizacaoCheckList dados){
        var checkList = repository.getReferenceById(dados.id());
        checkList.atualizacaoInfomacaoCheckList(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var checkList = repository.getReferenceById(id);
        checkList.excluir(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCheckList(checkList));
    }

    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity ativar(@PathVariable Long id){
        var checkList = repository.getReferenceById(id);
        checkList.ativar(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCheckList(checkList));
    }
*/
}
