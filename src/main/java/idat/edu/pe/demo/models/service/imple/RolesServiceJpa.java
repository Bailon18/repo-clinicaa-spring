package idat.edu.pe.demo.models.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.demo.models.entity.Roles;
import idat.edu.pe.demo.models.repository.IRolesRepo;
import idat.edu.pe.demo.models.service.IRolesService;

@Service
public class RolesServiceJpa implements IRolesService {

	
	@Autowired
	private IRolesRepo rolesRepo;
	
	
	@Override
	@Transactional(readOnly = true) // solo de lectura
	public List<Roles> listaRoles() {
		return rolesRepo.findAll();
	}

	
	@Override
	@Transactional
	public Roles nuevoRol(Roles rol) {
		return rolesRepo.save(null);
	}

}
