package idat.edu.pe.demo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "citas")
public class Citas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechacita;

    private int horacita;

    private String modalidad;

    @JoinColumn(name = "psicologo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario psicologo;

    @JoinColumn(name = "paciente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paciente paciente;

    private String nota;

    private String estadocita;


    @JoinColumn(name = "servicio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Servicio servicio;


    public Citas() {
    }

    public Citas(Date fechacita, int horacita, String modalidad, Usuario psicologo, Paciente paciente, String nota,
            String estadocita, Servicio servicio) {
        this.fechacita = fechacita;
        this.horacita = horacita;
        this.modalidad = modalidad;
        this.psicologo = psicologo;
        this.paciente = paciente;
        this.nota = nota;
        this.estadocita = estadocita;
        this.servicio = servicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechacita() {
        return fechacita;
    }

    public void setFechacita(Date fechacita) {
        this.fechacita = fechacita;
    }

    public int getHoracita() {
        return horacita;
    }

    public void setHoracita(int horacita) {
        this.horacita = horacita;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Usuario getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Usuario psicologo) {
        this.psicologo = psicologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getEstadocita() {
        return estadocita;
    }

    public void setEstadocita(String estadocita) {
        this.estadocita = estadocita;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }


    private static final long serialVersionUID = 1L;
}
