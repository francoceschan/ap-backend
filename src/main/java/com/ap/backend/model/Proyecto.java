package com.ap.backend.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre", nullable = false)
    private String nombre;

    @Column (name = "link", nullable = false)
    private String link;

    @Column (name = "descripcion", nullable = false)
    private String descripcion;

    public Proyecto() {
    }

    public Proyecto(Long id, String nombre, String link, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.link = link;
        this.descripcion = descripcion;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}


