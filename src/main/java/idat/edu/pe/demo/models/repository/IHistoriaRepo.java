package idat.edu.pe.demo.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import idat.edu.pe.demo.models.entity.Diagnostico;
import idat.edu.pe.demo.models.entity.Historia;

@Repository
public interface IHistoriaRepo extends JpaRepository<Historia, Long>{
    
	
    @Query("select h FROM Historia h WHERE h.paciente.id = ?1")
    Historia validarhistoria(Long id);
    
    @Query("select d FROM Diagnostico d WHERE d.historia.id = ?1")
    Diagnostico validardiagnostico(Long idhistoria);
	
}
