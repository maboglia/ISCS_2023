package com.boglia.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boglia.model.Colore;
import com.boglia.model.Maglia;

@RestController
@RequestMapping("api")
public class RestCtrl {

	
	@GetMapping("prova")
	public List<Maglia> prova() {
		
		Maglia m = new Maglia(15, "W Eclipse", Colore.BLU, 48);
		Maglia m2 = new Maglia(12, "Abbasso IntelliJ e Livio e PLant", Colore.VERDE, 46);
		
		return List.of(m, m2);
	}
	
}
