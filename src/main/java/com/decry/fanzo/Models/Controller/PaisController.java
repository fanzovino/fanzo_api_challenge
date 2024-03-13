package com.decry.fanzo.Models.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.decry.fanzo.Models.*;
import com.decry.fanzo.Services.*;


@RestController
@RequestMapping("/api/pais")
public class PaisController {
	
	@Autowired
	private PaisService paisservice;
	
	@GetMapping
	public List<Pais> getAllPaiss(){
		return paisservice.GetAllPais();
	}
	
//	@PostMapping
//	public Pais AddPais(@RequestBody Pais pais) {
//		 return paisservice.AddPais(pais);
//		 
//	}
	@GetMapping("/{Id}")
	public Pais getPaisbyId(@PathVariable Long Id) {
		return paisservice.getPaisbyId(Id);
	}
	@DeleteMapping("/{Id}")
	public void DeletePais(@PathVariable Long Id) {
		 paisservice.deletePaisbyId(Id);
	}
}
