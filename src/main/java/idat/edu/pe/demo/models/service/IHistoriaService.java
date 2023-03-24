package idat.edu.pe.demo.models.service;

import idat.edu.pe.demo.models.entity.Diagnostico;
import idat.edu.pe.demo.models.entity.Historia;

public interface IHistoriaService {

    Historia buscarhistoriaId(Long id);
    
    Historia validarexistenciahistoria(Long idpaciente);
    
    Diagnostico validarexistenciadiag(Long idhistoria);

    Historia guardarhistoria(Historia histo);
    
    Historia actualizarhistoria(Historia histo);

}
