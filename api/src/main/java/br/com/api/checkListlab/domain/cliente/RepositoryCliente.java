package br.com.api.checkListlab.domain.cliente;


import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCliente extends JpaRepository<Cliente, Long>{

    Page<Cliente> findAllByAtivoTrue(Pageable pageable);

    Page<Cliente> findAllByAtivoFalse(Pageable pageable);
    
}
