package ar.edu.unlam.tallerweb1.modelo;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_ciudad;
	private String nombre;
	@OneToMany(mappedBy="ciudad")
	private List<Ubicacion> ubicacionGeografica;// devuelve una lista de ubicaciones
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
	
	public List<Ubicacion> getUbicGeo(){
		return ubicacionGeografica;
	}
	
	public void setUbicGeo(List<Ubicacion> ubicacionGeografica) {
		this.ubicacionGeografica=ubicacionGeografica;
	}

}
