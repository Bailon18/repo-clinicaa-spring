package idat.edu.pe.demo.models.service;

import java.util.List;

import idat.edu.pe.demo.models.entity.Usuario;



public interface IUsuariosService {

	// listar usuarios
	List<Usuario> listarUsuario();
	
	// metodo para guardar un nuevo usuario
	Usuario guardarUsuario(Usuario usuario);

	// busqueda usuario unico atravez del id
	Usuario buscarPorId(Long id);

	Usuario bloquearUsuario(Long id);

	Usuario actualizarUsuario(Usuario usuario);
			
	Usuario validarIngreso(String usuario, String contrasena);

	Usuario validarCorreo(String correo);

	Usuario validarDni(String dni);


}
