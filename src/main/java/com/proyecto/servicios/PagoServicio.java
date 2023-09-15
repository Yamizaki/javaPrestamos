/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.servicios;

import com.proyecto.modelos.Pagos;
import java.util.List;

/**
 *
 * @author lol
 */
public interface PagoServicio {
    
    public List<Pagos> listarPagos();
    
    public void guardar(Pagos pagos);
    
    public Pagos encontrarPago(Integer id);
}
