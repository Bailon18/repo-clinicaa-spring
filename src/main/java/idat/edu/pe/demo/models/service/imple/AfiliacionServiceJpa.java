package idat.edu.pe.demo.models.service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.demo.models.entity.Afiliacion;
import idat.edu.pe.demo.models.repository.IAfiliacionRepo;
import idat.edu.pe.demo.models.service.IAfiliacionService;

@Service
public class AfiliacionServiceJpa implements IAfiliacionService{

    @Autowired
    private IAfiliacionRepo afirepo;


    @Override
    public Afiliacion guardarafiliacion(Afiliacion afi) {
        return afirepo.save(afi);
    }


    @Override
    public Afiliacion validarafiliacion(Long id) {
        return afirepo.validarafiliacion(id);
    }


    @Override
    public Afiliacion actualizarafiliacion(Afiliacion afi) {
        
        Afiliacion afiactual = afirepo.findById(afi.getId()).get();

        if( afiactual!= null ){

            afiactual.setEstadocierre(afi.getEstadocierre());
            afiactual.setFechaafiliacion(afi.getFechaafiliacion());
            afiactual.setFechacierre(afi.getFechacierre());
            afiactual.setPaciente(afi.getPaciente());
            afiactual.setPsicologo(afi.getPsicologo());
            afiactual.setTuvocierre(afi.getTuvocierre());

            return afirepo.save(afi);

        }
        
        
        return null;
    }
    
}
