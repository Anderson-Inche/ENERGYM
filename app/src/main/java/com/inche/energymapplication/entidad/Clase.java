package com.inche.energymapplication.entidad;

import java.util.Date;

public class Clase {
    private String id;
    private String descripcion;
    private String profesor;
    private Integer cupos;
    private String fecha;
    private String hora;

    public Clase(String id, String descripcion, String profesor, Integer cupos, String fecha, String hora) {
        this.id = id;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.cupos = cupos;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
