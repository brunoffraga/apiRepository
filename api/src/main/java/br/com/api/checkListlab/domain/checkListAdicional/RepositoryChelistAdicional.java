package br.com.api.checkListlab.domain.checkListAdicional;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.checkListlab.domain.regiao.Regiao;

public interface RepositoryChelistAdicional extends JpaRepository<CheckListAdicional, Long>{

    Page<Regiao> findAllByAtivoTrue(Pageable pageable);

    Page<Regiao> findAllByAtivoFalse(Pageable pageable);

    
}
