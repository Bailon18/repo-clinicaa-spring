package idat.edu.pe.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.demo.models.entity.Afiliacion;
import idat.edu.pe.demo.models.service.IAfiliacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/afiliacion")
public class AfiliacionController {
    

    @Autowired
    private IAfiliacionService afiservice;

    @PostMapping("/guardarafiliacion")
    public ResponseEntity<Object> agregarPaciente(@RequestBody Afiliacion afi) {
        Afiliacion afinuevo = afiservice.guardarafiliacion(afi);
        return new ResponseEntity<Object>(afinuevo, HttpStatus.CREATED);
    }


    @GetMapping(value="/validarafiliacion/{id}")
    public ResponseEntity<Object>  getMethodName(@PathVariable(name = "id") Long id) {
        Afiliacion afil= afiservice.validarafiliacion(id);
        return new ResponseEntity<Object>(afil, HttpStatus.OK);
    }
    

    @PutMapping("/actualizarafiliacion")
    public ResponseEntity<Object> actualizarafiliacion(@RequestBody Afiliacion afi) {

		System.out.println("afiliacion actualizar "+afi);

        Afiliacion afinuevo = afiservice.actualizarafiliacion(afi);
        return new ResponseEntity<Object>(afinuevo, HttpStatus.CREATED);
    }
    
}
