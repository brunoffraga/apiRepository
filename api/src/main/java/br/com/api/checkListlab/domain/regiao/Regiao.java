package br.com.api.checkListlab.domain.regiao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * autor: Bruno
 * 
 * estrutuar o codigo,
 * com o novo modelo que estou apreendendo
 */

@Table(name = "regiao")
@Entity(name = "Regiao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Regiao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String responsavel;

    public Regiao(DadosCadastroRegiao dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.responsavel = dados.responsavel();
    }

    public void atualizacaoInfomacaoRegiao(DadosAtualizacaoRegiao dados){
        this.nome = dados.nome();
        this.responsavel = dados.responsavel();
    }

    public void excluir(Long id) {
        this.ativo = false;
    }

    public void ativar(Long id) {
        this.ativo = true;
    }
}
