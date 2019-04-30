package ar.edu.unlam.tallerweb1.persistencia;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Pais;

public class IdiomaPaisTest extends SpringTest {

	@Test @Transactional @Rollback
	public void buscarIdiomaPais() {
		
		Session session = getSession();
		
		Pais nuevosPaises = new Pais();
		
		nuevosPaises.setNombre("Inglaterra");
		nuevosPaises.setIdioma("ingles");
		session.save(nuevosPaises);
		
		nuevosPaises.setNombre("Brazil");
		nuevosPaises.setIdioma("Portugues");
		session.save(nuevosPaises);
		
		
		@SuppressWarnings("unchecked")
		List<Pais> listaPaises = (List<Pais>) session.createCriteria(Pais.class)
			.add(Restrictions.eq("idioma","Portugues"))
			.list();
		
		assertThat(listaPaises.size()).isEqualTo(1);
		
	}

}
