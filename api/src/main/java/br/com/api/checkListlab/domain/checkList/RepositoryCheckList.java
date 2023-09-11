package br.com.api.checkListlab.domain.checkList;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCheckList extends JpaRepository<CheckList, Long>{
    
    Page<CheckList> findAllByAtivoTrue(Pageable pageable);

    Page<CheckList> findAllByAtivoFalse(Pageable pageable);
}
