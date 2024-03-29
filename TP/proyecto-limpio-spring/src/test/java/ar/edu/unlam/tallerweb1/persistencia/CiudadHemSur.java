package ar.edu.unlam.tallerweb1.persistencia;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

public class CiudadHemSur extends SpringTest{
	
	@Test@Rollback@Transactional
	public void PaisHemSurTest() {
		
		Session session = getSession();
		double ecuador = 00.00;	
		
		Continente America = new Continente();
		America.setNombre("America");
		session.save(America);
				
		Pais argentina = new Pais();
		argentina.setNombre("Argentina");
		argentina.setHabitantes(44000000);
		argentina.setIdioma("Espaniol");
		argentina.setContinente(America);
		session.save(argentina);
		
		Ubicacion ubiLaPlata = new Ubicacion();
		ubiLaPlata.setLatitud(-34.92068);
		ubiLaPlata.setLongitud(-57.953764);
		session.save(ubiLaPlata);
		
		Ciudad laPlata = new Ciudad();
		laPlata.setNombre("La Plata");
		laPlata.setPais(argentina);
		laPlata.setUbicGeo(ubiLaPlata);
		session.save(laPlata);
		
		argentina.setCapital(laPlata);
		session.save(argentina);
						
		Pais estadosUnidos = new Pais();
		estadosUnidos.setNombre("Estados Unidos");
		estadosUnidos.setHabitantes(327000000);
		estadosUnidos.setIdioma("Ingles");
		estadosUnidos.setContinente(America);
		session.save(estadosUnidos);
		
		Ubicacion newYorkUbi = new Ubicacion();
		newYorkUbi.setLatitud(43.1561681);
		newYorkUbi.setLongitud(-75.8449946);
		session.save(newYorkUbi);

		Ciudad newYork = new Ciudad();
		newYork.setNombre("New York");
		newYork.setPais(estadosUnidos);
		newYork.setUbicGeo(newYorkUbi);
		session.save(newYork);

		Ubicacion washingtonUbi = new Ubicacion();
		washingtonUbi.setLatitud(38.8950712);
		washingtonUbi.setLongitud(-77.0362758);
		session.save(washingtonUbi);
		
		Ciudad washington = new Ciudad();
		washington.setNombre("Washington");
		washington.setPais(estadosUnidos);
		washington.setUbicGeo(washingtonUbi);
		session.save(washington);
		
		estadosUnidos.setCapital(washington);
		session.save(estadosUnidos);
		

		@SuppressWarnings("unchecked")
		List<Ciudad> lista = (List<Ciudad>) session.createCriteria(Ciudad.class)
							 .createAlias("ubicacionGeografica","ubi")
							 .add(Restrictions.le("ubi.latitud", ecuador))
							 .list();
		
		assertThat(lista.size()).isEqualTo(1);
				
	}

}
