package com.boglia.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boglia.model.Colore;
import com.boglia.model.Maglia;

@Controller
@RequestMapping(path = {"/", "mvc"})
public class RouterCtrl {

	
	@GetMapping({"index", "home", ""})
	public String home(Model m) {
		m.addAttribute("titolo", "Home Page");
		return "homepage";
	}
	
	@GetMapping("login")
	public String login(Model m) {
		m.addAttribute("titolo", "Login Page");
		return "login";
	}
	
	@GetMapping("magazzino")
	public String magazzino(Model m) {
		m.addAttribute("titolo", "Magazzino Page");
		
		Maglia m1 = new Maglia(15, "W Eclipse", Colore.BLU, 48);
		Maglia m2 = new Maglia(12, "Abbasso IntelliJ e Livio e PLant", Colore.VERDE, 46);

		m.addAttribute("maglie", List.of(m1, m2));
		
		return "magazzino";
	}
	
	@GetMapping("prodotti")
	public String prodotti(Model m) {
		m.addAttribute("titolo", "Prodotti Page");
		return "prodotti";
	}
	
	@PostMapping("login")
	public String doLogin(@RequestParam String username, @RequestParam String password ) {
		
		if (username.equals("mauro")&& password.equals("12345")) {
			return "redirect:magazzino";
		}
		return "redirect:login";
		
	}
	
}
