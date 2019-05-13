package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.criterion.Restrictions;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class PaisNorteTropicoCancer extends SpringTest{

	@Test @Transactional @Rollback
	public void buscarPaisAlNorteDelTropicoDeCancer() {
		Session session = getSession();
		double latCancer= 23.43722;
		double latCiudad = 45.5208;
		double latBsAs = -34.9314;
		double latLima =  -34.05;
		
		Ubicacion ubicacionBsAs = new Ubicacion();
		Ciudad ciudadBsAs = new Ciudad();
		Pais paisBsAs = new Pais();
		
		ubicacionBsAs.setLatitud(latBsAs);
		session.save(ubicacionBsAs);
		
		ciudadBsAs.setNombre("Buenos Aires");
		ciudadBsAs.setUbicGeo(ubicacionBsAs);
		session.save(ciudadBsAs);
		
		paisBsAs.setNombre("Argentina");
		paisBsAs.setCapital(ciudadBsAs);
		session.save(paisBsAs);
		
		Ubicacion ubicacion = new Ubicacion();
		Ciudad ciudad = new Ciudad();
		Pais pais = new Pais();
		
		ubicacion.setLatitud(latCiudad);
		session.save(ubicacion);
		
		ciudad.setNombre("Ottawa");
		ciudad.setUbicGeo(ubicacion);
		session.save(ciudad);
		
		ubicacion.setCiudad(ciudad);
		session.save(ubicacion);
		
		pais.setNombre("Canada");
		pais.setCapital(ciudad);
		session.save(pais);
	
		Ubicacion ubicacionLima = new Ubicacion();
		Ciudad ciudadLima = new Ciudad();
		Pais paisLima = new Pais();
		
		ubicacionLima.setLatitud(latLima);
		session.save(ubicacionLima);
		
		ciudadLima.setNombre("Lima");
		ciudadLima.setUbicGeo(ubicacionLima);
		session.save(ciudadLima);
		
		paisLima.setNombre("Peru");
		paisLima.setCapital(ciudadLima);
		session.save(paisLima);
		
		@SuppressWarnings("unchecked")
		List<Pais> paisAlNorte= (List<Pais>) session.createCriteria(Pais.class)
			.createAlias("capital", "c")
			.createAlias("c.ubicacionGeografica", "ubicacionPais")
			.add(Restrictions.gt("ubicacionPais.latitud", latCancer))
			.list();
		
		assertThat(paisAlNorte.size()).isEqualTo(1);
		
		
		
	}

}
