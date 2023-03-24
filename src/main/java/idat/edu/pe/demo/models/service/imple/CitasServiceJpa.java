package idat.edu.pe.demo.models.service.imple;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.demo.models.entity.Citas;
import idat.edu.pe.demo.models.repository.ICitasRepor;
import idat.edu.pe.demo.models.service.ICitasService;

@Service
public class CitasServiceJpa implements ICitasService{

    @Autowired
    private ICitasRepor repositorio;

    @Override
    public List<Citas> buscarCitas(Long idPsicologa, Date fecha) {
        if(idPsicologa != null && fecha != null){
            return repositorio.buscarCitas(idPsicologa, fecha);
        }
        return null;
    }

    @Override
    public List<Integer> listardiascitas(Integer dia) {
        return repositorio.listardiascitas(dia);
    }

    @Override
    public Citas guardarcita(Citas cita) {
        return repositorio.save(cita);
    }

    @Override
    public List<Citas> listarcitas() {
        return repositorio.findAll();
    }

    @Override
    public List<Citas> validarcita(Long idPaciente, Date fecha) {
        return repositorio.validarcita(idPaciente,fecha);
    }

    @Override
    public Citas buscarcitasid(Long id) {
        
        if(id != null){
            Citas cita = repositorio.findById(id).get();
            if(cita != null){
                return cita;
            }
        }
        
        return null;
    }

	@Override
	public Citas actualizarcita(Citas cita) {
		
		Citas citaactual = repositorio.findById(cita.getId()).get();
		
		if(citaactual != null) {
			
			citaactual.setPaciente(cita.getPaciente());
			citaactual.setEstadocita(cita.getEstadocita());
			citaactual.setFechacita(cita.getFechacita());
			citaactual.setHoracita(cita.getHoracita());
			citaactual.setModalidad(cita.getModalidad());
			citaactual.setNota(cita.getNota());
			citaactual.setPsicologo(cita.getPsicologo());
			citaactual.setServicio(cita.getServicio());
			
			return repositorio.save(cita);
		}
		
		
		return null;
	}

	@Override
	public void eliminarcita(Long idci) {
		repositorio.deleteById(idci);
	}

	@Override
	public List<Object> listarcitasxpsicologa(Long idpsico) {
		
		List<Object> res = repositorio.listacitaspsicologa(idpsico);
		
		if(res != null) {
			return res;
		}
		
		return null;
	}



    
}
