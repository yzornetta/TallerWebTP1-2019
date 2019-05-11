package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CadenaOperacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cadena;
	private String operacionElegida;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCadena() {
		return cadena;
	}
	
	public String setCadena(String cadena) {
		return this.cadena=cadena;
	}
	
	public String getOperacion() {
		return operacionElegida;
	}
	public void setOperacion(String operacionElegida) {
		this.operacionElegida = operacionElegida;
	}


}
