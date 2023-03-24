package idat.edu.pe.demo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "afiliacion")
public class Afiliacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaafiliacion;

    @JoinColumn(name = "psicologo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario psicologo;

    private Boolean tuvocierre;

    @Temporal(TemporalType.DATE)
    private Date fechacierre;

    private String estadocierre;

    @OneToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id")
    private Paciente paciente;

    public Afiliacion() {
    }

    public Afiliacion(Date fechaafiliacion, Usuario psicologo, Boolean tuvocierre, Date fechacierre,
            String estadocierre, Paciente paciente) {
        this.fechaafiliacion = fechaafiliacion;
        this.psicologo = psicologo;
        this.tuvocierre = tuvocierre;
        this.fechacierre = fechacierre;
        this.estadocierre = estadocierre;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaafiliacion() {
        return fechaafiliacion;
    }

    public void setFechaafiliacion(Date fechaafiliacion) {
        this.fechaafiliacion = fechaafiliacion;
    }

    public Usuario getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Usuario psicologo) {
        this.psicologo = psicologo;
    }

    public Boolean getTuvocierre() {
        return tuvocierre;
    }

    public void setTuvocierre(Boolean tuvocierre) {
        this.tuvocierre = tuvocierre;
    }

    public Date getFechacierre() {
        return fechacierre;
    }

    public void setFechacierre(Date fechacierre) {
        this.fechacierre = fechacierre;
    }

    public String getEstadocierre() {
        return estadocierre;
    }

    public void setEstadocierre(String estadocierre) {
        this.estadocierre = estadocierre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    private static final long serialVersionUID = 1L;

}
