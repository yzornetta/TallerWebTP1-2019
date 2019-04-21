package ar.edu.unlam.tallerweb1.modelo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Ubicacion {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_ubicacion;
	private Float latitud;
	private Float longitud;
	@ManyToOne
	private Ciudad ciudad;
	
	
	//Agregado
	public Long getId_ubic() {
		return id_ubicacion;
	}
	
	public void setId_ubic(Long id_ubicacion) {
		this.id_ubicacion=id_ubicacion;
	}
	
	
	//Fin 
	public Float getLatitud() {
		return latitud;
	}
	
	public void setLatitud(Float latitud) {
		this.latitud = latitud;
	}
	
	public Float getLongitud() {
		return longitud;
	}
	
	public void setLongitud(Float longitud) {
		this.longitud = longitud;
	}
	
	public Ciudad getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
}
