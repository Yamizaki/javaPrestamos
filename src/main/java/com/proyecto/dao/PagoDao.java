package com.proyecto.dao;


import com.proyecto.modelos.Pagos;
import com.proyecto.modelos.Prestamo;
import org.springframework.data.repository.CrudRepository;

public interface PagoDao extends CrudRepository<Pagos, Integer>{

  
    
}
