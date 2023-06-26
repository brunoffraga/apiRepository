package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoAtualizaConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {

    public DadosDetalhamentoAtualizaConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}