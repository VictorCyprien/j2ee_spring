package fr.limayrac.controller;

import java.io.Console;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.limayrac.service.WeaponService;
import fr.limayrac.model.Weapon;

@RestController
public class WeaponsController {
	
	@Autowired
	private WeaponService weaponService;
	
	private static final Logger logger = LoggerFactory.getLogger(WeaponsController.class);
	
	@RequestMapping(value = "/weapon/list")
	@GetMapping(value = "/weapon/list")
	public ModelAndView listWeapons() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		return new ModelAndView("/flows/vault/listWeapons", "weapon", weaponService.getWeapon(currentUserName));
	}
	
	
	@PostMapping("/weapon/create")
	public ModelAndView checkWeaponInfo(@RequestParam String name, @RequestParam String description, @RequestParam String type) {
		Weapon weapon = new Weapon();
		weapon.setName(name);
		weapon.setDescription(description);
		weapon.setType(type);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		weapon.setUser(currentUserName);;
		
		weaponService.saveWeapon(weapon);
		return listWeapons();
	}

	
	
	@RequestMapping(value = "/weapon/create")
	@GetMapping("/weapon/create")
	public ModelAndView createWeapon() {
		return new ModelAndView("createWeapon", "weapon", new Weapon());
	}
	
	
	@RequestMapping(value = "/weapon/delete/{id}")
	public ModelAndView deleteWeapon(@PathVariable("id") final Integer id) {		
		weaponService.deleteWeapon(id);
		return new ModelAndView("redirect:/weapon/list");
	}
		
}