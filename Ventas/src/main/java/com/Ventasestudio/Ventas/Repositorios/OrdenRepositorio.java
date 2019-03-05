package com.Ventasestudio.Ventas.Repositorios;

import com.Ventasestudio.Ventas.Beans.orden;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdenRepositorio extends CrudRepository <orden,Integer> {

    @Query("SELECT o FROM orden o left join cliente c on c.id = o.cliente WHERE c.id =:clienteid")
     List<orden> ordenesXcliente(@Param("clienteid") Integer clienteid);

    @Query("SELECT o FROM orden o left join cliente c on c.id = o.cliente WHERE c.id =:clienteid AND o.Estado ='Activa'")
    List<orden> ordenClienteActiva(@Param("clienteid") Integer clienteid);

}
