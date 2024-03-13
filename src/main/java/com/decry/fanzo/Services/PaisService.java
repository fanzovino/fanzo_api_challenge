package com.decry.fanzo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decry.fanzo.Models.Pais;
import com.decry.fanzo.Repository.PaisRepository;

@Service
public class PaisService {
	
	@Autowired
	private PaisRepository paisrepository;
	
	public List<Pais> GetAllPais(){
		return (List<Pais>) paisrepository.findAll();
		}
	
	public Pais AddPais(Pais pais) {
		return paisrepository.save(pais);
	}
	public Pais getPaisbyId(long id) {
		return paisrepository.findById(id).orElse(null);
	}
	public void deletePaisbyId(Long id) {
		paisrepository.deleteById(id);
	}

	//Devuelvo false si el pais no esta en la lista
	public boolean validoPais(String pais) {
		for (Pais p : GetAllPais()) {
			if(pais.toUpperCase().equals(p.getNombre().toUpperCase())) {
				return true;
			}
		}
		return false;
	}
	

}
