package idat.edu.pe.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historia")
public class Historia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String motivoconsulta;

    @Column(columnDefinition = "integer default 1")
    private int tuvomedicacion;

    private String medicacion;

    @Column(columnDefinition = "integer default 1")
    private int tuvoriesgo;

    
    @JoinColumn(name = "riesgo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Riesgo riesgo; // OneToOne

    @Column(columnDefinition = "integer default 1")
    private int tuvoviolencia;

    @ManyToMany
    @JoinTable(name = "tiposviolencia", joinColumns = {
            @JoinColumn(name = "historia", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "violencia", referencedColumnName = "id") })
    private List<Violencia> historialista; // ManyToMany

    private String lugaratencionprevio;

    @Column(columnDefinition = "integer default 1")
    private int tuvodianosticoprevio;

    private String diagnosticoprevio;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "historia")
    private Diagnostico diagnostico; // OneToOne

    @OneToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id")
    private Paciente paciente;

    public Historia() {
    }

    public Historia(String motivoconsulta, int tuvomedicacion, String medicacion, int tuvoriesgo, Riesgo riesgo,
            int tuvoviolencia, List<Violencia> historialista, String lugaratencionprevio,
            int tuvodianosticoprevio, String diagnosticoprevio, Paciente paciente) {
        this.motivoconsulta = motivoconsulta;
        this.tuvomedicacion = tuvomedicacion;
        this.medicacion = medicacion;
        this.tuvoriesgo = tuvoriesgo;
        this.riesgo = riesgo;
        this.tuvoviolencia = tuvoviolencia;
        this.historialista = historialista;
        this.lugaratencionprevio = lugaratencionprevio;
        this.tuvodianosticoprevio = tuvodianosticoprevio;
        this.diagnosticoprevio = diagnosticoprevio;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotivoconsulta() {
        return motivoconsulta;
    }

    public void setMotivoconsulta(String motivoconsulta) {
        this.motivoconsulta = motivoconsulta;
    }

    public int getTuvomedicacion() {
        return tuvomedicacion;
    }

    public void setTuvomedicacion(int tuvomedicacion) {
        this.tuvomedicacion = tuvomedicacion;
    }

    public String getMedicacion() {
        return medicacion;
    }

    public void setMedicacion(String medicacion) {
        this.medicacion = medicacion;
    }

    public int getTuvoriesgo() {
        return tuvoriesgo;
    }

    public void setTuvoriesgo(int tuvoriesgo) {
        this.tuvoriesgo = tuvoriesgo;
    }

    public Riesgo getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(Riesgo riesgo) {
        this.riesgo = riesgo;
    }

    public int getTuvoviolencia() {
        return tuvoviolencia;
    }

    public void setTuvoviolencia(int tuvoviolencia) {
        this.tuvoviolencia = tuvoviolencia;
    }

    public List<Violencia> getHistorialista() {
        return historialista;
    }

    public void setHistorialista(List<Violencia> historialista) {
        this.historialista = historialista;
    }

    public String getLugaratencionprevio() {
        return lugaratencionprevio;
    }

    public void setLugaratencionprevio(String lugaratencionprevio) {
        this.lugaratencionprevio = lugaratencionprevio;
    }

    public int getTuvodianosticoprevio() {
        return tuvodianosticoprevio;
    }

    public void setTuvodianosticoprevio(int tuvodianosticoprevio) {
        this.tuvodianosticoprevio = tuvodianosticoprevio;
    }

    public String getDiagnosticoprevio() {
        return diagnosticoprevio;
    }

    public void setDiagnosticoprevio(String diagnosticoprevio) {
        this.diagnosticoprevio = diagnosticoprevio;
    }
    
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    private static final long serialVersionUID = 1L;
    
}
