package com.decry.fanzo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decry.fanzo.Models.Mercado;
import com.decry.fanzo.Repository.MercadoRepository;

@Service
public class MercadoService {
	
	@Autowired
	private MercadoRepository mercadorepository;
	
	public List<Mercado> GetAllMercados(){
		return (List<Mercado>) mercadorepository.findAll();
		}
	
	public Mercado AddMercado(Mercado mercado) {
		return mercadorepository.save(mercado);
	}
	public Mercado getMercadobyId(long id) {
		return mercadorepository.findById(id).orElse(null);
	}
	public void deleteMercadobyId(Long id) {
		mercadorepository.deleteById(id);
	}

	public Mercado findByCodigo(String codigo) {
		return mercadorepository.findByCodigo(codigo).orElse(null);
	}
	

}
