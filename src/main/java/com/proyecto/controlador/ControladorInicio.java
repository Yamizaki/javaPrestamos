package com.proyecto.controlador;

import com.proyecto.modelos.Pagos;
import com.proyecto.modelos.Prestamo;
import com.proyecto.servicios.PagoServicio;
import com.proyecto.servicios.PrestamoServicio;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorInicio {

    @Autowired
    private PrestamoServicio prestamoServicio;

    @Autowired
    private PagoServicio pagoServicio;

    @GetMapping("/")
    public String mostrarPrestamos(Model model) {
        var prestamos = prestamoServicio.listarPrestamos();
        model.addAttribute("prestamos", prestamos);
        return "index";
    }

    @GetMapping("/crear")
    public String crearPrestamo(Prestamo prestamo) {

        return "crearPrestamo";
    }

    @GetMapping("/ver/")
    public String verCuotas(Model model) {
       //Aqui la logica para mostrar las cuotas de cada prestamo...
      var cuotas = pagoServicio.listarPagos();
      model.addAttribute("pagos",  cuotas);
      
        
        return "verCuotas";
    }

    @PostMapping("/guardar")
    public String guardar(Prestamo prestamo) {

        var cuotas = prestamo.getCuotas();
        var capital = prestamo.getCapital();
        var interes = prestamo.getInteres() / 100;
        var monto = capital + (capital * interes);
        prestamo.setMonto(monto);

        prestamo.setFechaprestamo(new Date());
        prestamoServicio.guardar(prestamo);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        for (Integer i = 1; i <= cuotas; i++) {
            Pagos pagos = new Pagos();
            calendar.add(Calendar.MONTH, i);
            Date nuevaFecha = calendar.getTime();
            pagos.setFechavencimiento(nuevaFecha);
            pagos.setMonto(monto / cuotas);
            pagos.setNumerocuota(i);
            pagos.setPrestamo(prestamo);
            pagoServicio.guardar(pagos);
        }

        return "redirect:/";

    }

}
