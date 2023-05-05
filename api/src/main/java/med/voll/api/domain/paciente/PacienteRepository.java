package med.voll.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Page<Paciente> findAllByAtivoFalse(Pageable pageable);

    Page<Paciente> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            select p.ativo
            from  Pacientes p
            where
            p.id = :id
            """)
    boolean findAtivoById(Long id);
}