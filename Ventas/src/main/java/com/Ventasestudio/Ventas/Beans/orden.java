package com.Ventasestudio.Ventas.Beans;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class orden {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="cliente", nullable=false)
    private cliente cliente;
    @Temporal(TemporalType.DATE)
    private Date  fecha;

    private String Estado;

    @OneToMany(mappedBy="orden", cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private List<productoxorden> prods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public cliente getCliente() {
        return cliente;
    }


    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
