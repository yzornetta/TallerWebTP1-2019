package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;

public class PaisContinenteTest extends SpringTest{

	@Test @Transactional @Rollback
	public void buscarPaisDeUnContinenteTest() {
		Session session = getSession();
		
		Continente continenteAmericano = new Continente();
		Pais argentina = new Pais();
		
		continenteAmericano.setNombre("Argentina");
		session.save(continenteAmericano);
		
		argentina.setNombre("Argentina");
		argentina.setContinente(continenteAmericano);
		session.save(argentina);
		
		
		Continente continente= new Continente();
		Pais pais = new Pais();
		
		continente.setNombre("Europa");
		session.save(continente);
				
		pais.setNombre("Alemania");
		pais.setContinente(continente);
		session.save(pais);
		
		Pais inglaterra = new Pais();
		inglaterra.setNombre("Inglaterra");
		inglaterra.setContinente(continente);
		session.save(inglaterra);
		
				
		@SuppressWarnings("unchecked")
		List<Pais> listaPaisesEuropa = (List<Pais>) session.createCriteria(Pais.class)
				.createAlias("continente","c")
				.add(Restrictions.eq("c.nombre","Europa"))
				.list();
		
		assertThat(listaPaisesEuropa.size()).isEqualTo(2);
				
				
	}

}
