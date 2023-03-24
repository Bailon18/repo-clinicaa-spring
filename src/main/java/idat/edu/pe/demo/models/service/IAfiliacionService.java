package idat.edu.pe.demo.models.service;

import idat.edu.pe.demo.models.entity.Afiliacion;

public interface IAfiliacionService {
    
    Afiliacion guardarafiliacion(Afiliacion afi);

    Afiliacion validarafiliacion(Long id);

    Afiliacion actualizarafiliacion(Afiliacion  afi);
}
