package com.Ventasestudio.Ventas.Beans;
import javax.persistence.*;
import java.util.List;

@Entity
public class cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)


    private Integer id;
    private String user;
    private String correo;
    private String nombre;
    private String Apellido;
    private String direccion;


    @OneToMany(mappedBy="cliente", cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
    private List<orden> ordenes;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
