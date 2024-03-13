package com.decry.fanzo.cofig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decry.fanzo.Models.Comitente;
import com.decry.fanzo.Models.Mercado;
import com.decry.fanzo.Models.Pais;
import com.decry.fanzo.Repository.ComitenteRepository;
import com.decry.fanzo.Repository.MercadoRepository;
import com.decry.fanzo.Repository.PaisRepository;

import jakarta.annotation.PostConstruct;

//Carga la info al inciarlizar el contexto spring
@Component
public class DataInitializer {

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private ComitenteRepository comitenteRepository;
    @Autowired
    private MercadoRepository mercadoRepository;

    @PostConstruct
    public void init() {
    	//inicializo la api Pais. 
    	
        Pais argentina = new Pais();
        argentina.setNombre("Argentina");
        paisRepository.save(argentina);

        Pais uruguay = new Pais();
        uruguay.setNombre("Uruguay");
        paisRepository.save(uruguay);
        
        

		Comitente comitente1 = new Comitente();
		comitente1.setNombre("ComitenteAB");

		Comitente comitente2 = new Comitente();
		comitente2.setNombre("ComitenteCD");
		
		comitente1 = comitenteRepository.save(comitente1);
		comitente2 = comitenteRepository.save(comitente2);
		
		
		Mercado mer1 = new Mercado();
		mer1.setCodigo("101");
		mer1.setDescripcion("Mercado101");
		mer1.setPais(argentina.getNombre());
		
		Mercado mer2 = new Mercado();
		mer2.setCodigo("202");
		mer2.setDescripcion("Mercado202");
		mer2.setPais(uruguay.getNombre());


		mercadoRepository.save(mer1);
		mercadoRepository.save(mer2);
		
		List<Comitente> comitentesM1 = new ArrayList<>();
		comitentesM1.add(comitente1);
		comitentesM1.add(comitente2);
		
		mer1.setComitentes(comitentesM1);
		
		List<Comitente> comitentesM2 = new ArrayList<>();
		comitentesM2.add(comitente1);
		comitentesM2.add(comitente2);
		
		mer2.setComitentes(comitentesM2);
		
		//Guardo
		
		comitenteRepository.save(comitente1);
		comitenteRepository.save(comitente2);
        
        
        
    }
}