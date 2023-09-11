package br.com.api.checkListlab.domain.cliente;

import br.com.api.checkListlab.domain.regiao.Regiao;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "cliente")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean ativo;
    private Long idTotalControl;
    private String nomeCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    private Regiao regiao;

    public Cliente(DadosCadastroCliente dados){
        this.ativo = true;
        this.idTotalControl = dados.idTotalControl();
        this.nomeCliente = dados.nomeCliente();
    }

    public void atualizacaoInfomacaoCliente(DadosAtualizacaoCliente dados){
        this.idTotalControl = dados.idTotalControl();
        this.nomeCliente = dados.nomeCliente();
    }

    public void excluir(Long id) {
        this.ativo = false;
    }

    public void ativar(Long id) {
        this.ativo = true;
    }

}
