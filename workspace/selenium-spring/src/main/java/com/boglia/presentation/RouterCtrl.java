package com.boglia.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boglia.model.Colore;
import com.boglia.model.Maglia;
import com.boglia.model.Prodotto;
import com.google.gson.Gson;

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

	@GetMapping("prodotti/{id}")
	public String prodotto(@PathVariable int id,Model m) {
		
		HttpURLConnection connection;
		StringBuilder sb = new StringBuilder(); 
		BufferedReader reader;
		String riga;
		try {
			URL url = new URL("https://fakestoreapi.com/products/" + id);
			connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			int status = connection.getResponseCode();
			
			System.out.println(status);
			
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			while ((riga = reader.readLine()) != null) {
				sb.append(riga);
			}
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(sb.toString());
		
		Gson gson = new Gson();
		Prodotto p = gson.fromJson(sb.toString(), Prodotto.class);
		
		//System.out.println(p);
		
		//System.out.println("Vuoi visualizzare l'id " + id);
		
		if (p!=null) {
			m.addAttribute("titolo", p.getTitle());
			m.addAttribute("prodotto", p);//qui manca il DTO
			return "dettaglio";
		}
			else {
				m.addAttribute("titolo", "Prodotti Page");
				return "redirect:/prodotti";
			}
		}	
	
	@PostMapping("login")
	public String doLogin(@RequestParam String username, @RequestParam String password ) {
		
		if (username.equals("mauro")&& password.equals("12345")) {
			return "redirect:magazzino";
		}
		return "redirect:login";
		
	}
	
}
