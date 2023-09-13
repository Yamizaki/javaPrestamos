/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.servicios;

import com.proyecto.modelos.Prestamo;
import java.util.List;

/**
 *
 * @author lol
 */
public interface PrestamoServicio {
    
    public List<Prestamo> listarPrestamos();
    
    public void guardar(Prestamo persona);
    
 
    
    public Prestamo encontrarPrestamo(Prestamo persona);
}
