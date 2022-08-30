package com.ap.backend.model;

import javax.persistence.*;

@Entity
@Table(name="personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    @Column (name = "titulo", nullable = false)
    private String titulo;

    public Persona() {

    }

    public Persona(Long id, String nombre, String titulo) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
