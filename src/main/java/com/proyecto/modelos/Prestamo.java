/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.modelos;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;


/**
 *
 * @author lol
 */
@Data
@Entity
@Table(name="prestamo")
public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprestamo;
    
    private Double capital;
    private Double interes;
    private Double monto;
    private Integer cuotas;
    
    @Temporal(TemporalType.DATE)
    private Date fechaprestamo;
    
    @OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL)
    private List<Pagos> pagos;

}