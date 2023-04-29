package fr.limayrac.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.limayrac.service.ArmorService;
import fr.limayrac.model.Armor;

@RestController
public class ArmorController {
	
	@Autowired
	private ArmorService armorService;
	
	private static final Logger logger = LoggerFactory.getLogger(ArmorController.class);
	
	@RequestMapping(value = "/armor/list")
	@GetMapping(value = "/armor/list")
	public ModelAndView listArmors() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		return new ModelAndView("/flows/vault/listArmors", "armor", armorService.getArmor(currentUserName));
	}
	
	@RequestMapping(value = "/armor/list/{id}", method = RequestMethod.GET)
	public ModelAndView detailArmors(@PathVariable("id") final Integer id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		Optional<Armor> armor = armorService.getArmor(id);
		
		String user = armor.get().getUser();
		
		if (user.equals(currentUserName)){
			return new ModelAndView("armors_list_detail", "armor", armor.orElse(null));
		} 
		
		return new ModelAndView("armors_list_detail", "armor", null);
	}
	
	
	@PostMapping("/armor/create")
	public ModelAndView checkArmorInfo(@ModelAttribute("armor") Armor armor, ModelMap model) {
		model.addAttribute("name", armor.getName());
		model.addAttribute("description", armor.getDescription());
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		armor.setUser(currentUserName);
		
		armorService.saveArmor(armor);
		return listArmors();
	}

	
	@RequestMapping(value = "/armor/create")
	@GetMapping("/armor/create")
	public ModelAndView createArmor() {
		return new ModelAndView("armor_create", "armor", new Armor());
	}

	
	@RequestMapping(value = "/armor/delete/{id}")
	public ModelAndView deleteArmor(@PathVariable("id") final Integer id) {
		armorService.deleteArmor(id);
		return new ModelAndView("redirect:/armor/list");
	}
		
}