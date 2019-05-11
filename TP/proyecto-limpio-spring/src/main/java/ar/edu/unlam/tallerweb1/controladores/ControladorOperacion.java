package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unlam.tallerweb1.modelo.*;

@Controller
public class ControladorOperacion {
	
	@RequestMapping("/operacion")
	public ModelAndView irAOperacion() {
		
		ModelMap modelo = new ModelMap();
		CadenaOperacion cadenaOperacion = new CadenaOperacion();
		modelo.put("cadenaOperacion", cadenaOperacion);
		return new ModelAndView("operaciones",modelo);
	}

}