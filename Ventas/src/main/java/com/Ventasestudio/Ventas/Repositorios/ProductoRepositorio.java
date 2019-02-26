package com.Ventasestudio.Ventas.Repositorios;

import com.Ventasestudio.Ventas.Beans.producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.util.annotation.Nullable;

import java.util.List;

public interface ProductoRepositorio extends CrudRepository<producto,Integer> {

    List<producto> findBynombreContaining(@Nullable String nombre);

}
