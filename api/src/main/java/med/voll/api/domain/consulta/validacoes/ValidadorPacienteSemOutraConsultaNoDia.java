/*
package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia  implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var primeiroHrario = dados.data().withHour(7);
        var segundoHorario = dados.data().withHour(18);
        //var pacientePossueOutraConsultaNoMesmoDia = repository.existsByPacienteIdAndDataBetween(dados.idpaciente, primeiroHrario, segundoHorario);

        //if (pacientePossueOutraConsultaNoMesmoDia) {
        //    throw new ValidacaoException("Consulta fora do horario de funcionamento da clinica");
        //}
    }
}
*/