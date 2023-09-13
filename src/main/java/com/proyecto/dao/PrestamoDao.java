package com.proyecto.dao;


import com.proyecto.modelos.Prestamo;
import org.springframework.data.repository.CrudRepository;

public interface PrestamoDao extends CrudRepository<Prestamo, Long>{
    
}
