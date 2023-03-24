package idat.edu.pe.demo.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import idat.edu.pe.demo.models.entity.EstadoCivil;

public interface IEstadoCivilRepo extends JpaRepository<EstadoCivil, Long> {
    
}
