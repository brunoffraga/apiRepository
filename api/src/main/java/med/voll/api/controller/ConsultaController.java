package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoatualizaConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @PostMapping
    public ResponseEntity agenda(@RequestBody @Valid DadosAgendamentoConsulta dadosAgendamentoConsulta){
        return ResponseEntity.ok(new DadosDetalhamentoatualizaConsulta(null, null, null, null));
    }
}
