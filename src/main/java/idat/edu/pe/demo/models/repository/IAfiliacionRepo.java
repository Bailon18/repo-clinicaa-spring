package idat.edu.pe.demo.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import idat.edu.pe.demo.models.entity.Afiliacion;

@Repository
public interface IAfiliacionRepo extends JpaRepository<Afiliacion, Long> {
    

    @Query("select a FROM Afiliacion a WHERE a.paciente.id = ?1")
    Afiliacion validarafiliacion(Long id);
}
