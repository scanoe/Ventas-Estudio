package com.Ventasestudio.Ventas.Repositorios;

import com.Ventasestudio.Ventas.Beans.Idproductoxorden;
import com.Ventasestudio.Ventas.Beans.orden;
import com.Ventasestudio.Ventas.Beans.producto;
import com.Ventasestudio.Ventas.Beans.productoxorden;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepositorioProductoxOrden extends CrudRepository<productoxorden,Integer> {

    List<productoxorden> findByorden(orden ordden);

    productoxorden  findById(Idproductoxorden id);
}
