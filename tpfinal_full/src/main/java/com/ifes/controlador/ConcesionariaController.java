package com.ifes.controlador;

import com.ifes.dom.Concesionaria;
import com.ifes.dom.Rodado;
import com.ifes.servicio.ServicioConcesionaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/concesionaria")
public class ConcesionariaController {

    @Autowired
    private ServicioConcesionaria servicio;

    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("lista", servicio.listar());
        return "concesionaria/listar";
    }

    @GetMapping("/informe")
    public String informe(Model model) {
        model.addAttribute("reporte", servicio.informe());
        return "concesionaria/informe";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("concesionaria", new Concesionaria());
        return "concesionaria/crear";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Concesionaria concesionaria) {
        if (concesionaria.getRodados() == null)
            concesionaria.setRodados(new ArrayList<Rodado>());
        servicio.guardar(concesionaria);
        return "redirect:/concesionaria/listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        Concesionaria c = servicio.listar().stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        if (c != null) servicio.eliminar(c);
        return "redirect:/concesionaria/listar";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Long id, Model model) {
        Concesionaria c = servicio.listar().stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("concesionaria", c);
        return "concesionaria/ver";
    }
}
