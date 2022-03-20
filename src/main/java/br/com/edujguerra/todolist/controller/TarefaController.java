package br.com.edujguerra.todolist.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.edujguerra.todolist.model.Tarefa;
import br.com.edujguerra.todolist.repository.TarefaRepository;
import br.com.edujguerra.todolist.model.Tarefa;
import br.com.edujguerra.todolist.repository.TarefaRepository;

@Controller
@RequestMapping("/tarefa")
public class TarefaController{
	@Autowired
	private TarefaRepository tarefarepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelandview = new ModelAndView("/tarefa/listar.html");
		
		List<Tarefa> tarefas = tarefarepository.findAll();
		modelandview.addObject("tarefas",tarefas);
				
		return modelandview;
	}
	
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("/tarefa/detalhar.html");
		
		Tarefa tarefa = tarefarepository.getById(id);
		modelandview.addObject("tarefa",tarefa);
		
		return modelandview;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("redirect:/tarefa");
		
		tarefarepository.deleteById(id);
		
		return modelandview;
	}	
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelandview = new ModelAndView("/tarefa/cadastro.html");
				
		modelandview.addObject("tarefa",new Tarefa());
		
		return modelandview;
	}	
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Tarefa tarefa) {
		ModelAndView modelandview = new ModelAndView("redirect:/tarefa");
		
		tarefarepository.save(tarefa);
		
		return modelandview;
	}
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelandview = new ModelAndView("/tarefa/edicao.html");
		
		Tarefa tarefa = tarefarepository.getById(id);
		modelandview.addObject("tarefa",tarefa);
		
		return modelandview;
	}
	
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Tarefa tarefa) {
		ModelAndView modelandview = new ModelAndView("redirect:/tarefa");
		
		tarefarepository.save(tarefa);
		
		return modelandview;
	}	
}