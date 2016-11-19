package br.com.gmf.api.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Redirect to DOCS API
 * @author Junior
 *
 */
@Controller
public class SwaggerController {
	
	@RequestMapping("/docs")
	public String showDocs() {
		return "redirect:/swagger-ui.html";
	}
}
