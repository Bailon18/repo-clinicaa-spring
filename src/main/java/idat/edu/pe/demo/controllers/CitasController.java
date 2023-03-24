package idat.edu.pe.demo.controllers;

import java.util.Date;
import java.util.List;

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

import idat.edu.pe.demo.Dtos.CitasDTO;
import idat.edu.pe.demo.models.entity.Citas;
import idat.edu.pe.demo.models.service.ICitasService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/citas")
public class CitasController {

	@Autowired
	private ICitasService servicio;

	@GetMapping("/listarcitas")
	public ResponseEntity<Object> listarcitas() {

		List<Citas> listadoCitas = servicio.listarcitas();
		return new ResponseEntity<Object>(listadoCitas, HttpStatus.OK);
	}

	@GetMapping("/buscarcitasid/{id}")
	public ResponseEntity<Object> buscarcitasid(@PathVariable(name = "id") Long id) {

		Citas cita = servicio.buscarcitasid(id);

		if (cita != null) {

			CitasDTO citadto = new CitasDTO(cita.getId(), cita.getFechacita(), cita.getHoracita(), cita.getModalidad(),
					cita.getPsicologo().getNombres() + " " + cita.getPsicologo().getApellidos(), cita.getPsicologo().getId(),
					cita.getPaciente().getId(),
					cita.getPaciente().getNombre() + " " + cita.getPaciente().getApellidos(),
					cita.getNota(), cita.getEstadocita(), cita.getServicio().getId());

			return new ResponseEntity<Object>(citadto, HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/buscarcitas/{idpsico}/{fecha}")
	public ResponseEntity<Object> buscarCitas(@PathVariable(name = "idpsico") Long idpsico,
			@PathVariable(name = "fecha") Date fecha) {

		List<Citas> listadoCitas = servicio.buscarCitas(idpsico, fecha);
		if (listadoCitas != null) {
			return new ResponseEntity<Object>(listadoCitas, HttpStatus.OK);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/listardias/{mes}")
	public ResponseEntity<Object> listardias(@PathVariable(name = "mes") Integer mes) {

		List<Integer> listadias = servicio.listardiascitas(mes);
		if (mes == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(listadias, HttpStatus.OK);
	}

	@PostMapping("/guardarcita")
	public ResponseEntity<Object> agregarcita(@RequestBody Citas citas) {

		// validamos -> preguntamos si el paciente ya esta registrado en esa fecha
		// si lo esta va retornar la cita => aqui retornamos null
		// si no esta regresa vacio => aqui es donde guardamos la cita
		List<Citas> cita = servicio.validarcita(citas.getPaciente().getId(), citas.getFechacita());

		if (cita.size() == 0) {
			Citas citanueva = servicio.guardarcita(citas);
			return new ResponseEntity<Object>(citanueva, HttpStatus.CREATED);
		}
		return null;

	}
	
	@PutMapping("/actualizarcita")
	public Citas actualizarcita(@RequestBody Citas cita){
		return servicio.actualizarcita(cita);
	}
 	
	@GetMapping("/eliminarcita/{idcita}")
	public void eliminarcita(@PathVariable(name = "idcita") Long idcita) {
		servicio.eliminarcita(idcita);
	}
	
	@GetMapping("/listarcitasxpiscologa/{idpsico}")
	public List<Object> listarcitaxpsicologa(@PathVariable(name = "idpsico") Long idpsico){
		
		return servicio.listarcitasxpsicologa(idpsico);
	}
}
