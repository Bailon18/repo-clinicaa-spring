package idat.edu.pe.demo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import idat.edu.pe.demo.Dtos.PacienteDTO;
import idat.edu.pe.demo.models.entity.EstadoCivil;
import idat.edu.pe.demo.models.entity.Ocupacion;
import idat.edu.pe.demo.models.entity.Paciente;
import idat.edu.pe.demo.models.service.IPacientesService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/paciente")
public class PacienteController {

    @Autowired
    private IPacientesService pacservice;

    @GetMapping("/listarPacientes")
    public ResponseEntity<Object> listarPacientes() {
        List<Paciente> listadoPac = pacservice.listarPacientes();
        return new ResponseEntity<Object>(listadoPac, HttpStatus.OK);
    }

    @GetMapping("/listarOcupaciones")
    public ResponseEntity<Object> listarOcupaciones() {
        List<Ocupacion> listadoOcu = pacservice.listarOcupacion();
        return new ResponseEntity<Object>(listadoOcu, HttpStatus.OK);
    }

    @GetMapping("/listarEstadoCi")
    public ResponseEntity<Object> listarEstadoCivil() {
        List<EstadoCivil> listadoEstCiv = pacservice.listarEstadoCivil();
        return new ResponseEntity<Object>(listadoEstCiv, HttpStatus.OK);
    }

    @PostMapping("/guardarPaciente")
    public ResponseEntity<Object> agregarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteNuevo = pacservice.guardarPaciente(paciente);
        return new ResponseEntity<Object>(pacienteNuevo, HttpStatus.CREATED);
    }

    @GetMapping("/buscarPaciente/{id}")
    public ResponseEntity<Object> buscarPacienteId(@PathVariable(name = "id") Long id) {
        Paciente paciente = pacservice.buscarPorId(id);
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(paciente, HttpStatus.OK);
    }

    @GetMapping("/pagendar/{dni}")
    public ResponseEntity<Object> buscarpacienteagendar(@PathVariable(name = "dni") String dni) {

        if (dni != null) {

            Paciente paciente = pacservice.pacientecita(dni);

            if (paciente != null) {
                
                ModelMapper modelmaper = new ModelMapper();

                PacienteDTO pacienteDTO = modelmaper.map(paciente, PacienteDTO.class);
                // System.out.println("DTO "+pacienteDTO);

                return new ResponseEntity<Object>(pacienteDTO, HttpStatus.OK);
            }
        }
        return null;

    }

    @PutMapping("/actualizarPaciente")
    public ResponseEntity<Object> actualizarPaciente(@RequestBody Paciente paciente) {
        Paciente pacienteActual = pacservice.buscarPorId(paciente.getId());
        if (pacienteActual == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        pacservice.actualizarPaciente(paciente);
        return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
    }
    
	@GetMapping(value="/validarcorreo/{correo}")
	public Paciente validarCorreo(@PathVariable(value = "correo") String correo) {
		return pacservice.validarCorreo(correo);
	}
	
	@GetMapping(value="/validardni/{documento}")
	public Paciente validarDni(@PathVariable(value = "documento") String documento) {
		return pacservice.validarDni(documento);
	}
    
	@GetMapping(value="/buscarpaciente/{idpsico}/{idpacien}")
	public Paciente buscarpaciente(@PathVariable(value = "idpsico") Long idpsico, 
			@PathVariable(value = "idpacien") Long idpacien) 
	{
		
		Paciente respuesta;
		
		List<Object> res = pacservice.busquedapacienteagendar(idpsico, idpacien);
		
		Paciente paciente = pacservice.buscarPorId(idpacien);
		
		if(res.size() == 0) {
			respuesta = null; // es porque el paciente pertenece a otra psicologa -> RETORNA NULL -> no se muestra nombr
		}else {
			 // es porque el paciente y psicologa conciden -> RETORNA USUARIO -> se muestra nombre
			// es por  el paciente no esta en afiliacion -> RETORNA USUARIO -> se muestra nombre
			respuesta = paciente;
		}
		
		return respuesta;
		
	}
    

}