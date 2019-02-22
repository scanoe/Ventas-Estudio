package com.Ventasestudio.Ventas;

import com.Ventasestudio.Ventas.Beans.producto;
import com.Ventasestudio.Ventas.Repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoRepositorio prod;

    @PostMapping("/in")
    public String addproducto(@RequestParam String nombre,@RequestParam String descripcion, @RequestParam Integer cantidad){

        producto p = new producto();
        p.setCantidad(cantidad);
        p.setDescripcion(descripcion);
        p.setNombre(nombre);

        prod.save(p);
        return "exito";
    }


    @PostMapping("/fbyname")
    public List<producto> findproductoXname(@RequestParam String name){

        return prod.findBynombreContaining(name);
    }
}
