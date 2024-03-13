package com.decry.fanzo.Models.Controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.decry.fanzo.Models.*;
import com.decry.fanzo.Services.*;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/comitente")
public class ComitenteController {

	@Autowired
	private ComitenteService comitenteservice;
	@Autowired
	private MercadoService mercadoservice;
	
	@ApiOperation(value 	= "Obtiene todos los Comitentes", 
			      notes 	= "Puede visualizar el comitente con los mercados relacionados.",
			      response	= List.class)
    @GetMapping	
	public List<Comitente> getAllComitentes(){
		return comitenteservice.GetAllComitentes();
	}

	
	@ApiOperation(value = "Creaun nuevo Comitente", 
			      notes = "Crea un nuevo Comitente con la información proporcionada en el cuerpo de la solicitud")
    @PostMapping
	public Comitente AddComitente(@RequestBody Comitente comitenteRequest) {

		Comitente comitenteSave = new Comitente();
		comitenteSave.setNombre(comitenteRequest.getNombre());
		//comitenteSave.setMercados(comitenteRequest.getMercados());
        
        // Guardar el mercado sin las relaciones
       // mercadoRepository.save(mercado);
		comitenteSave = comitenteservice.AddComitente(comitenteSave);
        
        // Obtener los mercados y asignarlos al coimitente
        List<Mercado> mercados = new ArrayList<>();
        for (Mercado m : comitenteRequest.getMercado()) {
//            Optional<Mercado> comitenteOptional = Optional.of(mercadoservice.findByCodigo(m.getCodigo()));
//            comitenteOptional.ifPresent(mercados::add);
        	mercados.add(mercadoservice.AddMercado(m));
        }
        
        
        comitenteSave.setMercado(mercados); //comitenteRequest.getMercados()
        
        // Guardar el mercado con las relaciones actualizadas
       // mercadoRepository.save(mercado);
		
		
		 //return mercadoservice.AddMercado(mercado);
		 
	
		 return comitenteservice.AddComitente(comitenteSave);
		 
	}
	
	@ApiOperation(value = "Obtiene el Comitente por ID, de ser necesario haga uso de /getAllComitentes para idenficarlo", 
				  notes = "Obtiene un Comitente en particular ID")
   	@GetMapping("/{Id}")
	public Comitente getComitentebyId(@PathVariable Long Id) {
		return comitenteservice.getComitentebyId(Id);
	}
	
	@ApiOperation(value = "Elimina el Comitente por ID, de ser necesario haga uso de /getAllComitentes para idenficarlo", 
				  notes = "Elimina un Comitente según el ID")   
	@DeleteMapping("/{Id}")
	public void DeleteComitente(@PathVariable Long Id) {
		 comitenteservice.deleteComitentebyId(Id);
	}
	
}
