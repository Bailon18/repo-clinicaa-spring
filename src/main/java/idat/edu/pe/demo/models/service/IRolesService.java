package idat.edu.pe.demo.models.service;

import java.util.List;

import idat.edu.pe.demo.models.entity.Roles;


public interface IRolesService {
	
    List<Roles> listaRoles();
    
    Roles nuevoRol(Roles rol);
    
}
