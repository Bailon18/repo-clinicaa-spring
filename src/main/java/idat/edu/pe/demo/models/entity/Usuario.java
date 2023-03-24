package idat.edu.pe.demo.models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String dni;

	private String nombres;

	private String apellidos;

	private String correo;

	private String contrasena;

	private String sexo;

	@Column(name="estado", columnDefinition="varchar(20) default 'Activo'")
	private String estado;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "permisos", joinColumns = @JoinColumn(name = "usuarios_id", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
	private Collection<Roles> roles;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "psicologo")
    private List<Afiliacion> afiliacion;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "psicologo")
	private List<Citas> listacitas;

	public Usuario() {
	}

	public Usuario(Long id, String nombres, String apellidos, String correo, String contrasena) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
	}

	public Usuario(Long id, String dni, String nombres, String apellidos, String correo, String contrasena, String sexo,
			String estado, Collection<Roles> roles) {
		this.id = id;
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
		this.sexo = sexo;
		this.estado = estado;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	private static final long serialVersionUID = 1L;

}
