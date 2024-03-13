package com.decry.fanzo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decry.fanzo.Models.Comitente;
import com.decry.fanzo.Repository.ComitenteRepository;

@Service
public class ComitenteService {
	
	@Autowired
	private ComitenteRepository comitenterepository;
	
	public List<Comitente> GetAllComitentes(){
		return (List<Comitente>) comitenterepository.findAll();
		}
	
	public Comitente AddComitente(Comitente comitente) {
		return comitenterepository.save(comitente);
	}
	public Comitente getComitentebyId(long id) {
		return comitenterepository.findById(id).orElse(null);
	}
	public void deleteComitentebyId(Long id) {
		comitenterepository.deleteById(id);
	}

	public Comitente findByNombre(String nombre) {
		return comitenterepository.findByNombre(nombre).orElse(null);
	}
	

}
