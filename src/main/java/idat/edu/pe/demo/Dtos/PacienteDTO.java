package idat.edu.pe.demo.Dtos;



public class PacienteDTO {
  
	private Long id;

	private String nombre;

	private String apellidos;

	private String documento;

    public PacienteDTO() {
    }


    public PacienteDTO(String nombre, String apellidos, String documento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    

}
