package br.com.api.checkListlab.domain.check;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "chek")
@Entity(name = "Chek")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chek;
    private boolean ativo;

    public Check(DadosAtualizacaoCadastroCheck dados) {
        this.ativo = true;
        this.chek = dados.chek();
    }

    public void atualizacaoInfomacaoCheck(DadosAtualizacaoCadastroCheck dados) {
        this.chek = dados.chek();
    }

    public void excluir(Long id){
        this.ativo = false;
    }
    
    public void ativar(Long id){
        this.ativo = true;
    }
}
