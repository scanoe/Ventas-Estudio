package com.Ventasestudio.Ventas;
import com.Ventasestudio.Ventas.Beans.cliente;
import com.Ventasestudio.Ventas.Repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
@Autowired
private ClienteRepositorio  clien;
@PostMapping("/In")
public @ResponseBody  String addcliente(@RequestParam String nombre,@RequestParam String apellido,@RequestParam String direccion,
                                        @RequestParam String correo,@RequestParam String user) throws Exception{
    try{
    cliente cli =new cliente();
    cli.setNombre(nombre);
    cli.setApellido(apellido);
    cli.setDireccion(direccion);
    cli.setUser(user);
    cli.setCorreo(correo);
        clien.save(cli);
    return "Guardado";}
    catch(Exception e){
        return ( e.getMessage());

    }

}
@PostMapping("/cdu")
public @ResponseBody String delclienteXuser(@RequestParam String user){
clien.deleteByUser(user);
return "Borrado Exitoso";
}

@PostMapping("/fbyu")

public @ResponseBody  cliente findClienteXuser(@RequestParam String user){
    cliente  n = clien.findByUser(user);

    return n;
}
    @PostMapping("/upcu")
    public @ResponseBody  String upclienteXuser(@RequestParam String user,@RequestParam String Nuser, @RequestParam String Correo,
                                                 @RequestParam String nombre,@RequestParam String direccion,@RequestParam String apellido){
        cliente  n = clien.findByUser(user);
        String us= (Nuser == "") ?   n.getUser(): Nuser;
        String cor = (Correo == "") ?   n.getCorreo():Correo;
        String nom = (nombre == "") ?   n.getNombre():nombre;
        String dir = (direccion =="") ?   n.getDireccion():direccion;
        String ape = (apellido == "") ?   n.getApellido():apellido;
        System.out.println("soy:"+Nuser);
        n.setUser(us);
        n.setCorreo(cor);
        n.setNombre(nom);
        n.setDireccion(dir);
        n.setApellido(ape);
        try {
            clien.save(n);
        }catch(Exception e){

            System.out.println( e.getMessage());
        }

        return "exito";

    }

}
