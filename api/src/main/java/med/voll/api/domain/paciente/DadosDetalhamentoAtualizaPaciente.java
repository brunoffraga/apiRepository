package med.voll.api.domain.paciente;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoAtualizaPaciente(Long id, Boolean ativo, String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoAtualizaPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getAtivo(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }

}
