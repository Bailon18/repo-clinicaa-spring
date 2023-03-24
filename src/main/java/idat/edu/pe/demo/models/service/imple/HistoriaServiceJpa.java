package idat.edu.pe.demo.models.service.imple;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.demo.models.entity.Diagnostico;
import idat.edu.pe.demo.models.entity.Historia;
import idat.edu.pe.demo.models.repository.IHistoriaRepo;
import idat.edu.pe.demo.models.service.IHistoriaService;

@Service
public class HistoriaServiceJpa implements IHistoriaService {

    @Autowired
    private IHistoriaRepo historiarepo;


    @Override
    public Historia buscarhistoriaId(Long id) {
        return historiarepo.findById(id).get();
    }


	@Override
	public Historia validarexistenciahistoria(Long idpaciente) {
		return historiarepo.validarhistoria(idpaciente);
	}


	@Override
	public Diagnostico validarexistenciadiag(Long idhistoria) {
		return historiarepo.validardiagnostico(idhistoria);
	}


	@Override
	public Historia guardarhistoria(Historia histo) {
		return historiarepo.save(histo);
	}


	@Override
	public Historia actualizarhistoria(Historia histo) {

		Historia histoactual = historiarepo.findById(histo.getId()).get();

		if(histoactual != null){
			historiarepo.save(histo);
		}

		return null;
	}
    
}
