package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class TpTest extends SpringTest {

	@Test @Transactional @Rollback
	public void test() {
		Pais nuevosPaises = new Pais();
		 
		 nuevosPaises.setNombre("Inglaterra");
		 Session session = getSession();
		 session.save(nuevosPaises);
		 
		 nuevosPaises.setIdioma("ingles");
		 Session sessionIdioma = getSession();
		 sessionIdioma.save(nuevosPaises);
		 
		 Pais idiomaBuscado = session.get(Pais.class, nuevosPaises.getId());
				
		 assertThat(idiomaBuscado.getIdioma()).isEqualTo("ingles"); 
	}
	
	@Test @Transactional @Rollback
	public void buscarContinente() {
		Pais paisContinente = new Pais();
		
		Continente continenteBuscado = new Continente();
		
		continenteBuscado.setNombre("Europa");
		Session sessionContinente = getSession();
		sessionContinente.save(continenteBuscado);
		
		paisContinente.setNombre("Italia");
		Session sessionPais = getSession();
		sessionPais.save(paisContinente);
		
		paisContinente.setContinente(continenteBuscado);
		Session sessionPaisContinente = getSession();
		sessionPaisContinente.save(paisContinente);
		
		assertThat(paisContinente.getContinente()).isEqualTo(continenteBuscado);
		
	}
	
	@Test @Transactional @Rollback
	public void buscarPaisNorte() {
		
		Continente continente = new Continente();
		Pais pais = new Pais();
		Ciudad ciudad = new Ciudad();
		Ubicacion ubicacion = new Ubicacion();
		
		continente.setNombre("America");
		Session sessionContinente = getSession();
		sessionContinente.save(continente);
		
		pais.setNombre("Canada");
		Session sessionNombre = getSession();
		sessionNombre.save(pais);
		
		pais.setCapital("Ottawa");
		Session sessionCapital = getSession();
		sessionCapital.save(pais);
		
		ciudad.setNombre("Ottawa");
		Session sessionCiudad = getSession();
		sessionCiudad.save(ciudad);
		
		ubicacion.setLatitud(45.4208f);
		Session sessionLatitud = getSession();
		sessionLatitud.save(ubicacion);
		
		assertThat(ubicacion.getLatitud()).isGreaterThan(0);
		
		
		
		
	}
	
	

}
