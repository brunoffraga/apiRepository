package br.com.api.checkListlab.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.checkListlab.domain.cliente.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private RepositoryCliente repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroCliente dados, UriComponentsBuilder uriComponentsBuilder){
        var cliente = new Cliente(dados);
        repository.save(cliente);

        var uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizadoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoAtualizadoCliente>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(null).map(DadosDetalhamentoAtualizadoCliente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/excluir")
    public ResponseEntity<Page<DadosDetalhamentoAtualizadoCliente>> listarEcluir(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(null).map(DadosDetalhamentoAtualizadoCliente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public void atualizacao(@RequestBody @Valid DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizacaoInfomacaoCliente(dados);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity excluir(@PageableDefault Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluir(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCliente(cliente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity ativar(@PageableDefault Long id){
        var cliente = repository.getReferenceById(id);
        cliente.ativar(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizadoCliente(cliente));
    }
}
