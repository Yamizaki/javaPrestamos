package com.proyecto.controlador;

import com.proyecto.servicios.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControladorInicio {
    @Autowired
    private PrestamoServicio prestamoServicio;
    
    
    @GetMapping("/")
    public String mostrarPrestamos(Model model){
        var prestamos = prestamoServicio.listarPrestamos();
        model.addAttribute("prestamos", prestamos);
        System.out.println(prestamos);
        return "index";
    }
}
