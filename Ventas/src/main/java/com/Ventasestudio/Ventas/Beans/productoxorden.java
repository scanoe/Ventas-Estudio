package com.Ventasestudio.Ventas.Beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class productoxorden {
    @EmbeddedId
    private Idproductoxorden id;

    @ManyToOne
    @MapsId("orden")
    @JoinColumn(name="orden", nullable=false)
     private orden orden;

    @ManyToOne
    @MapsId("producto")
    @JoinColumn(name="producto", nullable=false)
   private producto producto;

    private Integer cantidad;

    public Idproductoxorden getId() {
        return id;
    }

    public void setId(Idproductoxorden id) {
        this.id = id;
    }

    public com.Ventasestudio.Ventas.Beans.orden getOrden() {
        return orden;
    }

    public void setOrden(com.Ventasestudio.Ventas.Beans.orden orden) {
        this.orden = orden;
    }

    public com.Ventasestudio.Ventas.Beans.producto getProducto() {
        return producto;
    }

    public void setProducto(com.Ventasestudio.Ventas.Beans.producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}

