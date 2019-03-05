package com.Ventasestudio.Ventas;

import com.Ventasestudio.Ventas.Beans.*;
import com.Ventasestudio.Ventas.Repositorios.ClienteRepositorio;
import com.Ventasestudio.Ventas.Repositorios.OrdenRepositorio;
import com.Ventasestudio.Ventas.Repositorios.ProductoRepositorio;
import com.Ventasestudio.Ventas.Repositorios.RepositorioProductoxOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.Ventasestudio.Ventas.Beans.producto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/prord")
public class productoxordenController {
    @Autowired
    private ProductoRepositorio prod;
    @Autowired
    OrdenRepositorio ord;
    @Autowired
    RepositorioProductoxOrden prord;
    @Autowired
    private ClienteRepositorio cli;

    @PostMapping("/add")
    public String addprord(@RequestParam Integer producto,@RequestParam String user,@RequestParam  Integer cant){
         producto p = prod.findById(producto).get();




         if(cant< p.getCantidad()) {
             List<orden> listtaorden = ord.ordenClienteActiva(cli.findByUser(user).getId());
             orden o = new orden();
             if (listtaorden.size()> 0){

                  o = listtaorden.get(0);
             }else{


                 o.setEstado("Activa");
                 Date date = new Date();
                 o.setFecha(date);
                 o.setCliente(cli.findByUser(user));
                    try{
                 ord.save(o);
                    }catch (Exception e){return "error1";
                    }


             }
             Idproductoxorden id = new Idproductoxorden();
             id.setOrdenID(o.getId());
             id.setProductoID(p.getId());
             productoxorden op = new productoxorden();
             op.setCantidad(cant);
             op.setProducto(p);
             op.setOrden(o);
             op.setId(id);



             try {
                 prord.save(op);
             }catch(Exception e){
                 return e.getMessage();
             }

             return "Exito";

         }else{
             return "Cantidad invalida";
         }




    }
}
