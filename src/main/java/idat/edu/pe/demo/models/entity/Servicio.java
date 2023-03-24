package idat.edu.pe.demo.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "servicio")
public class Servicio implements Serializable {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descripcion;

    private Double monto;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio")
	private List<Citas> listacitas;

    public Servicio() {
    }

    public Servicio(String descripcion, Double monto) {
        this.descripcion = descripcion;
        this.monto = monto;
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }


    private static final long serialVersionUID = 1L;
    
    
}
