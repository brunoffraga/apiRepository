package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriComponentsBuilder){
        var medico = new Medico(dados);
        repository.save(medico);

        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtualizaMedico(medico));
    }

    /**
     * o normal é trazer 20 registors por padrão
     * só sai com um registro 1
     * http://localhost:8080/medicos?size=1
     * qual a pagina que eu quero carregar
     * http://localhost:8080/medicos?size=1&pafe=0
     * http:localhost:8080/medicos?size=1&page=2
     * quando usado o sort  é para fazer osdenasção
     * http:localhost:8080/medicos?sort,desc
     * quando qerer colocar mais é só chamar o
     * http:localhost:8080/medicos?sort,desc&sizr=2&page=1
     */

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
        return  ResponseEntity.ok(page);
    }

    @GetMapping("/medicosExcluidos")
    public ResponseEntity<Page<DadosListagemMedico>> listarExcluitods(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable) {
        var page = repository.findAllByAtivoFalse(pageable).map(DadosListagemMedico::new);
        return  ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity autualizar(@RequestBody @Valid DadosAtualizaMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInfomacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizaMedico(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir(id);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity detalhaMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoAtualizaMedico(medico));
    }

}