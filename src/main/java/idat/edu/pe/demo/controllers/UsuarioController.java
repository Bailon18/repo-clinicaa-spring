package idat.edu.pe.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.demo.models.entity.Usuario;
import idat.edu.pe.demo.models.service.IUsuariosService;



@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private IUsuariosService ususervice;
	
   @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return  ususervice.listarUsuario();
    }
	
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario agregarUsuario(@RequestBody Usuario usuario){
        return ususervice.guardarUsuario(usuario);
    }

    @GetMapping("/buscar/{id}")
	public Usuario buscarUsuarioId(@PathVariable Long id) {
		return ususervice.buscarPorId(id);
	}

    @PutMapping("/actualizar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario actualizar(@RequestBody Usuario usuario) {

		// sin el id para que haga un merch
		Usuario usuarioActual = ususervice.buscarPorId(usuario.getId());

		if(usuarioActual != null){

			usuarioActual.setNombres(usuario.getNombres());
			usuarioActual.setApellidos(usuario.getApellidos());
			usuarioActual.setCorreo(usuario.getCorreo());
			usuarioActual.setContrasena(usuario.getContrasena());
			usuarioActual.setCorreo(usuario.getCorreo());
			usuarioActual.setSexo(usuario.getSexo());
			usuarioActual.setEstado(usuario.getEstado());
			usuarioActual.setRoles(usuario.getRoles());
	
			return ususervice.actualizarUsuario(usuarioActual);
		}
		return null;
	}

	
	@GetMapping("/bloquearUsuario/{id}")
	public Usuario bloquearUsuario(@PathVariable(value = "id") Long id) {
		return ususervice.bloquearUsuario(id);
	}

	@GetMapping(value="/validarcorreo/{correo}")
	public Usuario validarCorreo(@PathVariable(value = "correo") String correo) {
		return ususervice.validarCorreo(correo);
	}
	
	@GetMapping(value="/validardni/{dni}")
	public Usuario validarDni(@PathVariable(value = "dni") String dni) {
		return ususervice.validarDni(dni);
	}
}
