/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.servicios;

import com.proyecto.dao.PrestamoDao;
import com.proyecto.modelos.Prestamo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lol
 */
@Service
public class PrestamoServicioImplementacion implements PrestamoServicio {

    @Autowired    
    private  PrestamoDao prestamoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Prestamo> listarPrestamos() {
        return (List<Prestamo>) prestamoDao.findAll();
    }

    @Override
    @Transactional()
    public void guardar(Prestamo prestamo) {
        prestamoDao.save(prestamo); 
    }



    @Override
    @Transactional(readOnly = true)
    public Prestamo encontrarPrestamo(Prestamo prestamo) {
        return prestamoDao.findById(prestamo.getIdprestamo()).orElse(null);
    }
    
    
    
}