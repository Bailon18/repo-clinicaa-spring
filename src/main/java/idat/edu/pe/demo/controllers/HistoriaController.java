package idat.edu.pe.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.demo.models.entity.Diagnostico;
import idat.edu.pe.demo.models.entity.Historia;
import idat.edu.pe.demo.models.service.IHistoriaService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/historia")
public class HistoriaController {

	@Autowired
	private IHistoriaService historiaSer;
	
	
	@GetMapping("/buscarHistoria/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") Long id) {
		Historia historia = historiaSer.buscarhistoriaId(id);
		if (historia != null) {
			return new ResponseEntity<Object>(historia, HttpStatus.OK);
		}
		return null;
	}
	
	@GetMapping("/buscarHistoriaxpaciente/{id}")
	public ResponseEntity<Object> buscarhistoriaxpaciente(@PathVariable("id") Long id) {
		Historia historia = historiaSer.validarexistenciahistoria(id);
		if (historia != null) {
			return new ResponseEntity<Object>(historia, HttpStatus.OK);
		}
		return null;
	}
	
	@GetMapping("/buscardiagnosticoxhistoria/{id}")
	public ResponseEntity<Object> buscardiagnosticoxhistoria(@PathVariable("id") Long id) {
		Diagnostico diag = historiaSer.validarexistenciadiag(id);
		if (diag == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(diag, HttpStatus.OK);
	}
	
	@PostMapping("/guardarhistoria")
    public ResponseEntity<Object> agregarhistoria(@RequestBody Historia histo) {
	
        Historia historianueva = historiaSer.guardarhistoria(histo);
        return new ResponseEntity<Object>(historianueva, HttpStatus.CREATED);
    }

    @PutMapping("/actualizarhistoria")
    public ResponseEntity<Object> actualizarafiliacion(@RequestBody Historia histo) {
		System.out.println("historia actualizar "+histo);
        Historia historianueva = historiaSer.actualizarhistoria(histo);
        return new ResponseEntity<Object>(historianueva, HttpStatus.CREATED);
    }
	

}
