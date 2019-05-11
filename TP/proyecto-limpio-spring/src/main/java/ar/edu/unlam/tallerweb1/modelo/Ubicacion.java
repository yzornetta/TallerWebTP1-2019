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
	private Long id_ubicacion;
	private double latitud;
	private double longitud;
	@OneToOne
	private Ciudad ciudad;
<<<<<<< HEAD
	
	
	//Agregado
	public Long getId_ubic() {
		return id_ubicacion;
	}
	
	public void setId_ubic(Long id_ubicacion) {
		this.id_ubicacion=id_ubicacion;
	}
	
	
	//Fin 
	public Float getLatitud() {
=======

	public double getLatitud() {
>>>>>>> master
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
