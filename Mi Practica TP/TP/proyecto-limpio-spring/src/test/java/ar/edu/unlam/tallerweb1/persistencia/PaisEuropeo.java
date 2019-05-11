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

public class PaisEuropeo extends SpringTest {
	
	@Test@Rollback@Transactional
	public void paisEuropeoTest() {
		
		Session session = getSession();	
		
		Continente america = new Continente();
		america.setNombre("America");
		session.save(america);
		
		Pais argentina = new Pais();
		argentina.setNombre("Argentina");
		argentina.setHabitantes(44000000);
		argentina.setIdioma("Espaniol");
		argentina.setContinente(america);
		session.save(argentina);
		
		Pais estadosUnidos = new Pais();
		estadosUnidos.setNombre("Estados Unidos");
		estadosUnidos.setHabitantes(327000000);
		estadosUnidos.setIdioma("Ingles");
		estadosUnidos.setContinente(america);		
		session.save(estadosUnidos);

		Continente europa = new Continente();
		europa.setNombre("Europa");
		session.save(europa);
		
		Pais inglaterra = new Pais();
		inglaterra.setNombre("Inglaterra");
		inglaterra.setHabitantes(55000000);
		inglaterra.setIdioma("Ingles");
		inglaterra.setContinente(europa);		
		session.save(inglaterra);
		
		Pais francia = new Pais();
		francia.setNombre("Francia");
		francia.setHabitantes(37000000);
		francia.setIdioma("Frances");
		francia.setContinente(europa);
		session.save(francia);

		@SuppressWarnings("unchecked")
		List<Pais> listaPaises = (List<Pais>) session.createCriteria(Pais.class)
									.createAlias("continente","c")
									.add(Restrictions.eq("c.nombre", "Europa"))
									.list();
		
		assertThat(listaPaises.size()).isEqualTo(2);
		
	}

}
