package es.fernando.spring.app.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.fernando.spring.app.entity.Cliente;
import es.fernando.spring.app.service.ClienteService;

/**
 * The Class AppController.
 */
@Controller
public class AppController {

	/** The dao. */
	@Autowired
	private ClienteService service;

	/**
	 * Listar.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("clientes", service.findAll());
		return "listar";
	}

	/**
	 * Form.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/form")
	public String form(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		return "form";
	}

	/**
	 * Guardar.
	 *
	 * @param cliente the cliente
	 * @param result the result
	 * @return the string
	 */
	@PostMapping(value = "/form")
	public String guardar(@Valid Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
			return "form";
		}
		service.save(cliente);
		return "redirect:/listar";
	}

	/**
	 * Form.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/form/{id}")
	public String form(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		Cliente cliente = null;

		if (id > 0) {
			cliente = service.findOne(id);
		} else {
			return "redirect:listar";
		}
		model.put("cliente", cliente);
		return "form";
	}

	/**
	 * Eliminar.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		if (id > 0) {
			service.delete(id);
		}
		return "redirect:/listar";

	}
}
