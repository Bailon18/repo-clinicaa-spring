package idat.edu.pe.demo.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.demo.models.entity.Ocupacion;


@Repository
public interface IOcupacionRepo extends JpaRepository<Ocupacion, Long>{
    
}
