package com.Ventasestudio.Ventas.Beans;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@Entity
public class producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer cantidad;

    @OneToMany(mappedBy="producto", cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private List <productoxorden> prods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
