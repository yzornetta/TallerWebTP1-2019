package ar.edu.unlam.tallerweb1.modelo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Ubicacion {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idUbicacion;
	private double latitud;
	private double longitud;
	@OneToOne
	private Ciudad ciudad;

	public Long getIdUbicacion(){
		return idUbicacion;
	}
	
	public void setIdUbicacion(Long idUbicacion){
		this.idUbicacion=idUbicacion;
	}
	
	public double getLatitud() {
		return latitud;
	}
	
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	public double getLongitud() {
		return longitud;
	}
	
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	public Ciudad getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
}
