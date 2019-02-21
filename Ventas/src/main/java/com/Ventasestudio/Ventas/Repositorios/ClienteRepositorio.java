package com.Ventasestudio.Ventas.Repositorios;
import org.springframework.data.repository.CrudRepository;
import com.Ventasestudio.Ventas.Beans.cliente;
import org.springframework.transaction.annotation.Transactional;


public interface ClienteRepositorio extends CrudRepository<cliente,Integer>{

    @Transactional
    void deleteByUser(String user);
    cliente findByUser(String user);
}

