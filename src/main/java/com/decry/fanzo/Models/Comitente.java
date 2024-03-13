package com.decry.fanzo.Models;

import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name="comitente")
public class Comitente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique = true)
    private String nombre;
    


    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable( name="comitentes_mercados",
    	       joinColumns = @JoinColumn(name="comitente_id", referencedColumnName = "id"),
    	       inverseJoinColumns = @JoinColumn(name="mercado_id", referencedColumnName = "id")
    		)
	 private List<Mercado> mercado;
	
	 
	 // GETTERS - SETTERS
	 
	 
    public Comitente( String nombre, List<Mercado> mercado) {
		super();
		this.nombre = nombre;
		this.mercado = mercado;
	}
    
	public Comitente() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Mercado> getMercado() {
		return mercado;
	}
	public void setMercado(List<Mercado> mercado) {
		this.mercado = mercado;
	}
    
	

	
    
}
