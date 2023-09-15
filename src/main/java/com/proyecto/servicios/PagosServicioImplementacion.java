/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.servicios;

import com.proyecto.dao.PagoDao;
import com.proyecto.modelos.Pagos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lol
 */
@Service
public class PagosServicioImplementacion implements PagoServicio {

    @Autowired    
    private  PagoDao pagoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pagos> listarPagos() {
         return (List<Pagos>) pagoDao.findAll();
    }

    @Override
    @Transactional()
    public void guardar(Pagos pagos) {
        pagoDao.save(pagos); 
    }

    @Override
    @Transactional(readOnly = true)
    public Pagos encontrarPago(Integer id) {
        return pagoDao.findById(id).orElse(null);
    }

   
    
    
   
    
}