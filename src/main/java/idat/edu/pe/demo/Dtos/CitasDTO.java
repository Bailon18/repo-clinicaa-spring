package idat.edu.pe.demo.Dtos;

import java.util.Date;

public class CitasDTO {
    

    private Long id;

    private Date fechacita;

    private int horacita;

    private String modalidad;

    private String psicologonombre;

    private Long psicologoid;

    private Long idpaciente;

    private String pacientenombres;

    private String nota;

    private String estadocita;

    private Long servicionombre;

    public CitasDTO() {
    }

    public CitasDTO(Long id, Date fechacita, int horacita, String modalidad, String psicologonombre, Long psicologoid,
            Long idpaciente, String pacientenombres, String nota, String estadocita, Long servicionombre) {
        this.id = id;
        this.fechacita = fechacita;
        this.horacita = horacita;
        this.modalidad = modalidad;
        this.psicologonombre = psicologonombre;
        this.psicologoid = psicologoid;
        this.idpaciente = idpaciente;
        this.pacientenombres = pacientenombres;
        this.nota = nota;
        this.estadocita = estadocita;
        this.servicionombre = servicionombre;
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

    public String getPsicologonombre() {
        return psicologonombre;
    }

    public void setPsicologonombre(String psicologonombre) {
        this.psicologonombre = psicologonombre;
    }

    public Long getPsicologoid() {
        return psicologoid;
    }

    public void setPsicologoid(Long psicologoid) {
        this.psicologoid = psicologoid;
    }

    public Long getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(Long idpaciente) {
        this.idpaciente = idpaciente;
    }

    public String getPacientenombres() {
        return pacientenombres;
    }

    public void setPacientenombres(String pacientenombres) {
        this.pacientenombres = pacientenombres;
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

    public Long getServicionombre() {
        return servicionombre;
    }

    public void setServicionombre(Long servicionombre) {
        this.servicionombre = servicionombre;
    }

    
    
    

}
