package com.ap.backend.model;

import javax.persistence.*;
import java.util.Date;

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

    @Column (name = "fechaInicio", nullable = false)
    private Date fechaInicio;

    @Column (name = "fechaFin", nullable = true)
    private Date fechaFin;

    public Educacion(){

    }

    public Educacion(Long id, String institucion, String titulo, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
