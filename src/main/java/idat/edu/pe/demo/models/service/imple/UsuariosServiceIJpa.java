package idat.edu.pe.demo.models.service.imple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.demo.models.entity.Usuario;
import idat.edu.pe.demo.models.repository.IUsuarioRepo;
import idat.edu.pe.demo.models.service.IUsuariosService;

@Service
public class UsuariosServiceIJpa implements IUsuariosService {

	@Autowired
	private IUsuarioRepo usuariorepo;
	
	@Override
	public List<Usuario> listarUsuario() {
		return usuariorepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuariorepo.save(usuario);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuarioretorno = usuariorepo.findById(id);
		if(usuarioretorno.isPresent()) {
            return usuarioretorno.get();
        } else {
            return null;
        }
	}

	@Override
	@Transactional
	public Usuario bloquearUsuario(Long id) {
		
		usuariorepo.bloquearUsuario(id);
		return buscarPorId(id);
	}

	@Override
	@Transactional
	public Usuario actualizarUsuario(Usuario usuario) {
		return usuariorepo.save(usuario);
		
	}

	@Override
	public Usuario validarIngreso(String usuario, String contrasena) {
	
		Usuario usu = usuariorepo.validarIngreso(usuario, contrasena);

		if(usu != null){
			return usu;
		}
		return null;
	}

	@Override
	public Usuario validarCorreo(String correo) {
		
		Usuario usuario = usuariorepo.validarCorreo(correo);
		if(usuario != null){
			return usuario;
		}
		return null;
	}

	@Override
	public Usuario validarDni(String dni) {
		
		Usuario usuario = usuariorepo.validarDni(dni);
		if(usuario != null){
			return usuario;
		}

		return null;
	}
}
