package br.com.fiap.convidados.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.convidados.dto.ConvidadoDto;
//import br.com.fiap.convidados.entity.ConvidadoEntity;
import br.com.fiap.convidados.service.ConvidadoService;

@Controller
@RequestMapping("convidados")
public class ConvidadosController {

	@Autowired
	ConvidadoService service;

	@GetMapping("/lista")
	public ModelAndView listar() {
		ModelAndView view = new ModelAndView("convidados/ListaConvidados");
		List<ConvidadoDto> convidados = service.findAll();
		view.addObject(new ConvidadoDto());
		view.addObject("convidados", convidados);
		return view;
	}

	@PostMapping("/salvar")
	public String salvar(@Valid ConvidadoDto convidadoDto, BindingResult result) {
		if(!result.hasErrors()) {
			service.save(convidadoDto);
			return "redirect:/convidados/lista";
		}
		return "redirect:/convidados/lista";
	}

	@GetMapping("/detalhar/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {		
		ModelAndView view = new ModelAndView("convidados/convidado-detalhar");	
		ConvidadoDto convidado = service.findById(id);
		view.addObject("convidado", convidado);
		return view;		
	}

	@GetMapping("/deletar/{id}")
	public String deletar(@PathVariable Long id) {
		service.deleteById(id);
		return "redirect:/convidados/lista";
	}
}
