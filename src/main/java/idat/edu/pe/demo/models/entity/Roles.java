package idat.edu.pe.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descripcion;

	private Boolean seleccion;

	public Roles() {
	}

	public Roles(Long id, String descripcion, Boolean seleccion) {
		this.id = id;
		this.descripcion = descripcion;
		this.seleccion = seleccion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(Boolean seleccion) {
		this.seleccion = seleccion;
	}

	private static final long serialVersionUID = 1L;

}
