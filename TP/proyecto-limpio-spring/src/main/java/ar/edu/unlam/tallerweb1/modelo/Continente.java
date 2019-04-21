package ar.edu.unlam.tallerweb1.modelo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Continente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_continente;
	private String nombre;
	
	
	//Agregado
	public Long getId_cont() {
		return id_continente;
	}
	
	public void setId_cont(Long id_continente) {
		this.id_continente=id_continente;
	}
	
	//Fin
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
