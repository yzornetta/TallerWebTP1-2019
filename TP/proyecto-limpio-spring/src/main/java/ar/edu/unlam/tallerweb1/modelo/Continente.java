package ar.edu.unlam.tallerweb1.modelo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Continente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContinente;
	private String nombre;
	
	
	//Agregado
	public Long getId_cont() {
		return idContinente;
	}
	
	public void setId_cont(Long idContinente) {
		this.idContinente=idContinente;
	}
	
	//Fin
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
