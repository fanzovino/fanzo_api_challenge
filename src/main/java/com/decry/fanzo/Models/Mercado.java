package com.decry.fanzo.Models;

import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name="mercado")
public class Mercado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(unique = true)
    private String codigo;
    
    private String descripcion;
    

    private String pais;
    

    @OneToMany(mappedBy = "mercado")
    private List<Comitente> comitentes;
    

	// GETTERS - SETTERS
    
    public Mercado(Long id, String codigo, String descripcion, String pais, List<Comitente> comitentes) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.pais = pais;
		this.comitentes = comitentes;
	}
    
	public Mercado() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public List<Comitente> getComitentes() {
		return comitentes;
	}
	public void setComitentes(List<Comitente> comitentes) {
		this.comitentes = comitentes;
	}
    
	

    
}
