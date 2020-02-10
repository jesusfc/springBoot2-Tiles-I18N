package com.controller;

import com.constant.ViewConstants;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("homeController")
public class HomeController extends CommonController {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 8676754911006063199L;
	private static Logger log = LogManager.getLogger(HomeController.class);

	@RequestMapping(value = "/" + ViewConstants.HOME_VIEW, method = RequestMethod.GET)
	public ModelAndView goToHomeView() {
		
		ModelAndView modelAndView = new ModelAndView(ViewConstants.HOME_VIEW, "view",  ViewConstants.HOME_VIEW);		
		
		try {
			
			System.out.println("HomeController.java - Debe tener al menos una sentencia.");

		} catch (Exception e) {
			log.warn("Error en goToHomeView: ", e);
		}
		
		return modelAndView;
	}

	@RequestMapping(value = "/" + ViewConstants.HTML_CSS_TEST, method = RequestMethod.GET)
	public ModelAndView goToCssTestView() {
		
		ModelAndView modelAndView = new ModelAndView(ViewConstants.HTML_CSS_TEST, "view",  ViewConstants.HTML_CSS_TEST);		
		
		try {

			System.out.println("HomeController.java - Debe tener al menos una sentencia.");
			
		} catch (Exception e) {
			log.warn("Error en goToCssTestView: ", e);
		}

		return modelAndView;
	}
	
	@RequestMapping(value = "/" + ViewConstants.JSTL_LIB_TEST, method = RequestMethod.GET)
	public ModelAndView goTojstlLibView() {
		
		ModelAndView modelAndView = new ModelAndView(ViewConstants.JSTL_LIB_TEST, "view",  ViewConstants.JSTL_LIB_TEST);		
		
		try {
			
			List<String> listado = new ArrayList<String>();
			listado.add("a");
			listado.add("b");
			listado.add("c");
			listado.add("d");
			listado.add("e");

			modelAndView.addObject("arrayList", listado);
			
		} catch (Exception e) {
			log.warn("Error en goToCssTestView: ", e);
		}

		return modelAndView;
	}

}
