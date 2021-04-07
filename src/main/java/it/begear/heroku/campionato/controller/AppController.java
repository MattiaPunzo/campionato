package it.begear.heroku.campionato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.begear.heroku.campionato.entity.Squadre;
import it.begear.heroku.campionato.service.SquadreService;

@Controller
public class AppController {

	@Autowired
	SquadreService squadreservice;

	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {

		List<Squadre> listSquadre = squadreservice.listAll(keyword);
		model.addAttribute("listsquadre", listSquadre);
		model.addAttribute("keyword", keyword);
		return "index";

	}

	@RequestMapping("/new")
	public String showNewSquadre(Model model) {
		Squadre squadre = new Squadre();

		model.addAttribute("squadre", squadre);

		return "nuova_squadra";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSquadre(@ModelAttribute("squadre") Squadre squadre) {
		squadreservice.save(squadre);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id_squadra}")
	public ModelAndView showEditNewSquadre(@PathVariable(name = "id_squadra") int id_squadra) {

		ModelAndView mav = new ModelAndView("edit_squadre");
		Squadre squadre = squadreservice.getSquadre(id_squadra);
		mav.addObject("squadre", squadre);

		return mav;
	}

	@RequestMapping("/delete/{id_squadra}")
	public String deleteSquadra(@PathVariable(name = "id_squadra") int id_squadra) {
		squadreservice.deleteSquadra(id_squadra);
		return "redirect:/";
	}
}
