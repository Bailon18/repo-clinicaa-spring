package idat.edu.pe.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.demo.models.entity.Usuario;
import idat.edu.pe.demo.models.service.IUsuariosService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping(value = "/login")
public class HomeController {

    @Autowired
    private IUsuariosService ususervice;

    @GetMapping("/validar/{correo}/{contra}")
    private Usuario validarIngreso(@PathVariable(value = "correo") String correo,
            @PathVariable(value = "contra") String contrasena) {

        return ususervice.validarIngreso(correo, contrasena);
    }
}
