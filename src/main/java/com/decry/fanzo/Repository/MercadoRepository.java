package com.decry.fanzo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.decry.fanzo.Models.Mercado;

public interface MercadoRepository extends CrudRepository<Mercado,Long>{

	Optional<Mercado> findByCodigo(String codigo);
	
}
