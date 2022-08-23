package com.ap.backend.model;

import javax.persistence.*;

@Entity
@Table(name="estudios")
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "institucion", nullable = false)
    private String institucion;

    @Column (name = "titulo", nullable = false)
    private String titulo;

    @Column (name = "anioInicio", nullable = false)
    private Integer anioInicio;

    @Column (name = "anioFin", nullable = true)
    private Integer anioFin;

    public Educacion(){

    }

    public Educacion(Long id, String institucion, String titulo, Integer anioInicio, Integer anioFin) {
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnioInicio() {
        return anioInicio;
    }

    public void setAnioInicio(Integer anioInicio) {
        this.anioInicio = anioInicio;
    }

    public Integer getAnioFin() {
        return anioFin;
    }

    public void setAnioFin(Integer anioFin) {
        this.anioFin = anioFin;
    }
}
