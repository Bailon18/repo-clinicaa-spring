package idat.edu.pe.demo.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import idat.edu.pe.demo.models.entity.Paciente;


@Repository
public interface IPacientesRepo extends JpaRepository<Paciente, Long> {

	
	// Consultas personalizadas
	
    @Query("select  p FROM Paciente p WHERE p.documento = ?1")
    Paciente pacientecita(String documento);
    
    @Query("select p FROM Paciente p WHERE p.correo = ?1")
    Paciente validarCorreo(String correo);

    @Query("select p FROM Paciente p WHERE p.documento = ?1")
    Paciente validarDni(String dni);
    

    @Query("select a FROM Afiliacion a WHERE (a.psicologo.id = ?1 and a.paciente.id = ?2) or  (?2 not in (select ab.paciente.id from Afiliacion ab))")
    List<Object> busquedaaaa(Long idpsico, Long idpacien);
}
