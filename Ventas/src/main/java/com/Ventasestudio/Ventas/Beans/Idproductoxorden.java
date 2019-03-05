package com.Ventasestudio.Ventas.Beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
 public class  Idproductoxorden implements Serializable {
    @Column(name = "producto")
    private Integer productoID;
    @Column(name = "orden")
    private Integer ordenID;

    public Integer getProductoID() {
        return productoID;
    }

    public void setProductoID(Integer productoID) {
        this.productoID = productoID;
    }

    public Integer getOrdenID() {
        return ordenID;
    }

    public void setOrdenID(Integer ordenID) {
        this.ordenID = ordenID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Idproductoxorden)) return false;
        Idproductoxorden that = (Idproductoxorden) o;
        return Objects.equals(getProductoID(), that.getProductoID()) &&
                Objects.equals(getOrdenID(), that.getOrdenID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductoID(), getOrdenID());
    }
}
