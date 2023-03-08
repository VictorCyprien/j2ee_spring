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
		return new ModelAndView("weapons_list", "weapon", weaponService.getWeapon(currentUserName));
	}
	
	@RequestMapping(value = "/weapon/list/{id}", method = RequestMethod.GET)
	public ModelAndView detailWeapons(@PathVariable("id") final Integer id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		Optional<Weapon> weapon = weaponService.getWeapon(id);
		
		String user = weapon.get().getUser();
		
		System.out.println(user);
		System.out.println(currentUserName);
				
		if (user.equals(currentUserName)){
			System.out.println("SAME !");
			return new ModelAndView("weapons_list_detail", "weapon", weapon.orElse(null));
		} 
		
		return new ModelAndView("weapons_list_detail", "weapon", null);
		
	}
	
	
	@PostMapping("/weapon/create")
	public ModelAndView checkWeaponInfo(@ModelAttribute("weapon") Weapon weapon, ModelMap model) {
		model.addAttribute("name", weapon.getName());
		model.addAttribute("description", weapon.getDescription());
		model.addAttribute("type", weapon.getType());
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUserName = authentication.getName();
		weapon.setUser(currentUserName);
		
		weaponService.saveWeapon(weapon);
		return listWeapons();
	}

	
	
	@RequestMapping(value = "/weapon/create")
	@GetMapping("/weapon/create")
	public ModelAndView createWeapon() {
		return new ModelAndView("weapon_create", "weapon", new Weapon());
	}
	
	
	@RequestMapping(value = "/weapon/delete/{id}")
	public ModelAndView deleteWeapon(@PathVariable("id") final Integer id) {		
		weaponService.deleteWeapon(id);
		return new ModelAndView("redirect:/weapon/list");
	}
		
}