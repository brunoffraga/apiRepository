package med.voll.api.domain.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ativo = true;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Enumerated
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInfomacoes(DadosAtualizaMedico dados) {
        System.out.println(dados.nome());
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        System.out.println(dados.telefone());
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        System.out.println(dados.dadosEndereco());
        if (dados.dadosEndereco() != null){
            this.endereco.atualizarInfomcoes(dados.dadosEndereco());
        }
    }

    public void excluir(Long id) {
        this.ativo = false;
    }

    public void ativarExcluido(Long id) {
        this.ativo = true;
    }
}
