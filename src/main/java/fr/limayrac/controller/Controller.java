package fr.limayrac.controller;

import fr.limayrac.model.User;
import fr.limayrac.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
public class Controller {

	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/vault")
	public String viewVaultPage() {
		return "vault";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		logger.info(user.toString());
		userRepo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/login")
	public String userLogin(Model model) {
		return "login";
	}
	
	@GetMapping("/logout")
	public String userLogout(HttpServletRequest request) {
	    // Récupérer la session
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        // Invalidons la session pour déconnecter l'utilisateur
	        session.invalidate();
	    }
	    // Rediriger vers la page de connexion ou une autre page de votre choix
	    return "logout";
	}
}








