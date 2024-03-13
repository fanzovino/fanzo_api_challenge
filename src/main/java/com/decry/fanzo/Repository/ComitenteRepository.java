package com.decry.fanzo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.decry.fanzo.Models.Comitente;

public interface ComitenteRepository extends CrudRepository<Comitente,Long>{

	Optional<Comitente> findByNombre(String nombre);
	
}
