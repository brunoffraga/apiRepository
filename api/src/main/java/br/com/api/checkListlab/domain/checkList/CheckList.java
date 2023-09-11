package br.com.api.checkListlab.domain.checkList;

import br.com.api.checkListlab.domain.cliente.Cliente;
import br.com.api.checkListlab.domain.check.Check;
import br.com.api.checkListlab.domain.checkListAdicional.CheckListAdicional;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "checkListi")
@Entity(name = "Checklisti")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CheckList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long numeroChamado;
    private boolean ativo;
    private String usuarioFazendo;
    
    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "check_id")
    private Check check;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "checkListAdicional_id")
    private CheckListAdicional checkListAdicional;

    public void excluir(Long id) {
        this.ativo = false;
    }

    public void ativar(Long id) {
        this.ativo = true;
    }
}
