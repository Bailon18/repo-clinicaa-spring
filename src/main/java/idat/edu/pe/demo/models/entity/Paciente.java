package idat.edu.pe.demo.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String apellidos;

	private String correo;

	private String telefono;

	private String sexo;
	
	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

    @JoinColumn(name = "ocupacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
	private Ocupacion ocupacion;

	@JoinColumn(name = "estadocivil", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private EstadoCivil estadocivil;

	private String documento;

	private String direccion;

	private String distrito;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Historia historia; // OneToOne

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
    private Afiliacion afiliacion; // OneToOne

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
	private List<Citas> listacitas;

	public Paciente() {
	}

	public Paciente(String nombre, String apellidos, String correo, String telefono, String sexo, Date fechanacimiento,
			Ocupacion ocupacion, EstadoCivil estadocivil, String documento, String direccion, String distrito) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.sexo = sexo;
		this.fechanacimiento = fechanacimiento;
		this.ocupacion = ocupacion;
		this.estadocivil = estadocivil;
		this.documento = documento;
		this.direccion = direccion;
		this.distrito = distrito;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Ocupacion getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}

	public EstadoCivil getEstadocivil() {
		return estadocivil;
	}

	public void setEstadocivil(EstadoCivil estadocivil) {
		this.estadocivil = estadocivil;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	private static final long serialVersionUID = 1L;

}