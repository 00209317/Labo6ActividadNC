package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.service.EstudianteService;

@Controller
public class MainController {
	
	/*@Autowired
	private EstudianteDAO estudianteDAO;*/
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/estudiante")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;		
		try {
			estudiantes = estudianteService.findAll();
		}
		catch(Exception e){
			e.printStackTrace();			
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value ="/mostrarEstudiante", method = RequestMethod.POST)
	public ModelAndView findOne(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try {
			estudiante = estudianteService.findOne(id);
			System.out.println("me vine para aca pq lo busque");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("me vine para aca pq no busque");
		}
		mav.addObject("estudiante", estudiante);
		mav.setViewName("Updateestudiante");
		return mav;
	}
	
	@PostMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("agregarEstudiante");
			System.out.println("Entre aqui pq tengo errores");
		}
		else {
			estudianteService.save(estudiante);
			List<Estudiante> estudiantes = null;
			try {
				estudiantes = estudianteService.findAll();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			mav.addObject("estudiantes", estudiantes);
			mav.setViewName("listaEstudiantes");
		}
		return mav;
	}
	
	@RequestMapping(value = "/borrarEstudiante", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudianteService.delete(id);
			estudiantes = estudianteService.findAll();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	@GetMapping("/insertarEstudiante")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("agregarEstudiante");
		return mav;
	}
	
	/*@RequestMapping("/main2")
	public ModelAndView main2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main2");
		return mav;
	}*/
	
	@RequestMapping(value = "/mostrarEstudiante2", method = RequestMethod.POST)
	public ModelAndView findOne2(@RequestParam(value="codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = estudianteService.findOne(id);
		mav.addObject("estudiante", estudiante);
		mav.setViewName("estudiante2");
		return mav;
	}

	
	@PostMapping(value = "/filtrar")
	public ModelAndView filtro(@RequestParam(value="nombre") String cadena) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			//estudiantes = estudianteService.empizaCon(cadena);
			estudiantes = estudianteService.filtrarPor(cadena);
			//estudiantes = estudianteService.findAll();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		mav.setViewName("main");
		mav.addObject("estudiantes", estudiantes);
		return mav;
	}
	
}
