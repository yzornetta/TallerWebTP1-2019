package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idCiudad;
	private String nombre;
	@OneToOne
	private Ubicacion ubicacionGeografica;
	@ManyToOne
	private Pais pais;
	
		
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Pais getPais(){
		return pais;
	}
	
	public void setPais(Pais pais) {
		this.pais=pais;
	}
	
	public Ubicacion getUbicGeo(){
		return ubicacionGeografica;
	}
	
	public void setUbicGeo(Ubicacion ubicacionGeografica) {
		this.ubicacionGeografica=ubicacionGeografica;
	}

}
