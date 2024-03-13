package com.decry.fanzo.Models;

import jakarta.persistence.*;

@Entity

@Table(name="pais")

public class Pais {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(unique=true)
    private String nombre;
    
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
    
    
}

//public enum Pais {
//    ARGENTINA("Argentina"),
//    URUGUAY("Uruguay");
//
//    private String nombre;
//
//    Pais(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    // Método estático para obtener un Pais basado en una cadena
//    public static Pais fromString(String nombre) {
//        for (Pais pais : Pais.values()) {
//            if (pais.nombre.equalsIgnoreCase(nombre)) {
//                return pais;
//            }
//        }
//        throw new IllegalArgumentException("Pais desconocido: " + nombre);
//    }
//}
