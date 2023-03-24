package idat.edu.pe.demo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "diagnostico")
public class Diagnostico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sintomas;
    private Boolean tienetranstorno;
    private String niveltranstorno;
    private String conclusion;
    private String otros;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @OneToOne
    @JoinColumn(name = "historia", referencedColumnName = "id")
    private Historia historia;

    public Diagnostico() {
    }

    public Diagnostico(String sintomas, Boolean tienetranstorno, String niveltranstorno, String conclusion,
            String otros, Date fecha, Historia historia) {
        this.sintomas = sintomas;
        this.tienetranstorno = tienetranstorno;
        this.niveltranstorno = niveltranstorno;
        this.conclusion = conclusion;
        this.otros = otros;
        this.fecha = fecha;
        this.historia = historia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Boolean getTienetranstorno() {
        return tienetranstorno;
    }

    public void setTienetranstorno(Boolean tienetranstorno) {
        this.tienetranstorno = tienetranstorno;
    }

    public String getNiveltranstorno() {
        return niveltranstorno;
    }

    public void setNiveltranstorno(String niveltranstorno) {
        this.niveltranstorno = niveltranstorno;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    private static final long serialVersionUID = 1L;
}
