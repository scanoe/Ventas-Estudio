package com.Ventasestudio.Ventas;
import com.Ventasestudio.Ventas.Beans.cliente;
import com.Ventasestudio.Ventas.Repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
@Autowired
private ClienteRepositorio  clien;
@PostMapping("/In")
public @ResponseBody  String addcliente(@RequestParam String nombre,@RequestParam String apellido,@RequestParam String direccion) throws Exception{
    try{
    cliente cli =new cliente();
    cli.setNombre(nombre);
    cli.setApellido(apellido);
    cli.setDireccion(direccion);
        clien.save(cli);
    return "Guardado";}
    catch(Exception e){
        return ( e.getMessage());

    }

}


}
