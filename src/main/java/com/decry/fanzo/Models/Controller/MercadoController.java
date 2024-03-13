package com.decry.fanzo.Models.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.decry.fanzo.Models.*;
import com.decry.fanzo.Services.*;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/mercado")
public class MercadoController {

	@Autowired
	private MercadoService mercadoservice;
	@Autowired
	private ComitenteService comitenteService;
	@Autowired
	private PaisService PaisService;
	
	@GetMapping
	public List<Mercado> getAllMercados(){
		return mercadoservice.GetAllMercados();
	}
	

	@ApiOperation(value = "Creaun nuevo comitente", 
			      notes = "Crea un nuevo mercado con la información proporcionada en el cuerpo de la solicitud")
	@PostMapping
	public ResponseEntity<?> AddMercado(@RequestBody Mercado mercadoRequest) {
		Mercado mercadoSave = new Mercado();
		mercadoSave.setCodigo(mercadoRequest.getCodigo());
		mercadoSave.setDescripcion(mercadoRequest.getDescripcion());
		mercadoSave.setPais(mercadoRequest.getPais());
        
		if(!PaisService.validoPais(mercadoRequest.getPais()) ) {
		//	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El País no esta permitido para esta aplicación.");
		}
        
		
		// Guardar el mercado sin las relaciones
        // mercadoRepository.save(mercado);
		mercadoSave = mercadoservice.AddMercado(mercadoSave);
        
        // Obtener los comitentes y asignarlos al mercado
        List<Comitente> comitentes = new ArrayList<>();
        for (Comitente c : mercadoRequest.getComitentes()) {
//          Optional<Mercado> comitenteOptional = Optional.of(mercadoservice.findByCodigo(m.getCodigo()));
//          comitenteOptional.ifPresent(mercados::add);
        	comitentes.add(comitenteService.AddComitente(c));
        }
        
        
        mercadoSave.setComitentes(comitentes);
        
        // Guardar el mercado con las relaciones actualizadas
       // mercadoRepository.save(mercado);
		
		
		 return ResponseEntity.ok(mercadoservice.AddMercado(mercadoSave));
		 
	}

	
	@ApiOperation(value = "Obtiene el Mercado por ID, de ser necesario haga uso de /getAllComitentes para idenficarlo", 
				  notes = "Obtiene un Mercado en particular ID")	
	@GetMapping("/{Id}")
	public Mercado getMercadobyId(@PathVariable Long Id) {
		return mercadoservice.getMercadobyId(Id);
	}
	
	@ApiOperation(value = "Elimina el Mercado por ID, de ser necesario haga uso de /getAllComitentes para idenficarlo", 
			  	notes = "Elimina un Mercado según el ID")
	@DeleteMapping("/{Id}")
	public void DeleteMercado(@PathVariable Long Id) {
		 mercadoservice.deleteMercadobyId(Id);
	}
}
