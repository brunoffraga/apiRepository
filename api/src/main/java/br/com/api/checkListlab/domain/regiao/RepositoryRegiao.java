package br.com.api.checkListlab.domain.regiao;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRegiao extends JpaRepository<Regiao, Long>{

    Page<Regiao> findAllByAtivoTrue(Pageable pageable);

    Page<Regiao> findAllByAtivoFalse(Pageable pageable);

}
