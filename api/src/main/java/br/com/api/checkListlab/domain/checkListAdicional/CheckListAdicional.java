package br.com.api.checkListlab.domain.checkListAdicional;

import br.com.api.checkListlab.domain.check.Check;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "checkListAdicional")
@Entity(name = "CheckListAdicional")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CheckListAdicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_id")
    private Check check;

    private boolean ativo;

    public CheckListAdicional(DadosCadastroChelistAdicional dados){
        this.ativo = true;
        this.check = dados.check();
    }

    public void atualizacaoInfomacaoChekListAdicional(DadosAtualizacaoChelistAdicional dados){
        this.check = dados.check();
    }
    
    public void excluir(Long id) {
        this.ativo = false;
    }

    public void ativar(Long id) {
        this.ativo = true;
    }
}