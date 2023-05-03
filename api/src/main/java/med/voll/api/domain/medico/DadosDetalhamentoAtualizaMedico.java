package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.Endereco;

public record DadosDetalhamentoAtualizaMedico(Long id, String nome, String email, String crm, String telefone, Epecialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoAtualizaMedico(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
