package idat.edu.pe.demo.models.service;

import java.util.Date;
import java.util.List;

import idat.edu.pe.demo.models.entity.Citas;

public interface ICitasService {
    
    List<Citas> buscarCitas(Long idPsicologa, Date fecha);

    Citas buscarcitasid(Long id);

    List<Integer> listardiascitas(Integer dia);

    Citas guardarcita(Citas cita);

    List<Citas> listarcitas();

    List<Citas> validarcita(Long idPaciente, Date fecha);
    
    Citas actualizarcita(Citas cita);
    
    void eliminarcita(Long idci);
    
    
    List<Object> listarcitasxpsicologa(Long idpsico);

}
