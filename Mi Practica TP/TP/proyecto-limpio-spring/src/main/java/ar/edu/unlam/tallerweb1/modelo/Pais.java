package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_pais;
	private String nombre;
	private int habitantes;
	private String idioma;
	@OneToOne
	private Ciudad capital;
	@ManyToOne
	private Continente continente;
	
	public Long getId() {
		return id_pais;
	}
	
	public void setId(Long id_pais) {
		this.id_pais = id_pais;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getHabitantes() {
		return habitantes;
	}
	
	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public Ciudad getCapital() {
		return capital;
	}
	
	public void setCapital(Ciudad capital) {
		this.capital = capital;
	}
	
	public Continente getContinente() {
		return continente;
	}
	
	public void setContinente(Continente continente) {
		this.continente = continente;
	}
}
