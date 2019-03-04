package com.Ventasestudio.Ventas;


import com.Ventasestudio.Ventas.Beans.cliente;
import com.Ventasestudio.Ventas.Beans.orden;
import com.Ventasestudio.Ventas.Repositorios.ClienteRepositorio;
import com.Ventasestudio.Ventas.Repositorios.OrdenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orden")
public class OrdenConttroller {

    @Autowired
    private OrdenRepositorio ordenRepo;

    @Autowired
    private ClienteRepositorio cli;
    @PostMapping("/addorden")
    public String addOrden(@RequestParam Integer cliente, @RequestParam Date fecha ){

        List<orden>ordenlist = ordenRepo.ordenClienteActiva(cliente);
        if (ordenlist.size()>0){
            return "Orden Activa";
        }

        orden o = new orden();

        o.setCliente(cli.findById(cliente).get());
        o.setEstado("Activa");
        o.setFecha(fecha);
        try {
            ordenRepo.save(o);

            return "Exito";
        }catch(Exception e){

            return e.getMessage();
        }
    }

    @PostMapping("/OrdC")
    public List<orden> orenesXcliente(Integer idCliente){

        return ordenRepo.ordenesXcliente(idCliente);
    }

    @PostMapping("/ordActClient")
    public List<orden> OrdenActivaXCliente(Integer idCliente){


        return ordenRepo.ordenClienteActiva(idCliente);
    }
}
