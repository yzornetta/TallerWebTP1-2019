package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ControladorOperacion {
	
	@RequestMapping("/{operacion}/{cadena}")
	public ModelAndView irASaludoPersona2(@PathVariable String operacion,
										  @PathVariable String cadena) {
		
		String resultadoCadena="";
				
		switch(operacion) {
			case "pasarAMayuscula":
				resultadoCadena=cadena.toUpperCase();
			break;
			case "pasarAMinuscula":
				resultadoCadena=cadena.toLowerCase();
			break;
			case "invertirOrden":
				StringBuilder builder=new StringBuilder(cadena);
				resultadoCadena= builder.reverse().toString();
			break;	
			case "cantidadDeCaracteres":
				resultadoCadena= Integer.toString(cadena.length());
			break;
		
		}
		

		ModelMap modelo = new ModelMap();
		modelo.put("operacion", operacion);
		modelo.put("cadena", cadena);
		modelo.put("resultadoCadena", resultadoCadena);
		
		return new ModelAndView("operaciones", modelo);
	}

}