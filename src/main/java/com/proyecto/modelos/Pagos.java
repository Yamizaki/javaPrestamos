/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.modelos;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;


/**
 *
 * @author lol
 */
@Data
@Entity
@Table(name="pagos")
public class Pagos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpago;
    
    private Double monto;
    private Double interes;
    private Integer numerocuota;
    
    @Temporal(TemporalType.DATE)
    private Date fechavencimiento;
    
    @ManyToOne
    @JoinColumn(name = "idprestamo")
    private Prestamo prestamo;

    
}