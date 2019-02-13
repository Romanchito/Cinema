package com.cinema.controllers.adminControllers;

import com.cinema.entities.OperationOfCinema;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/operationsOfCinema")
public class OperationOfCinemaController {

    @Autowired
    @Qualifier(value = "operationService")
    private Servicable<OperationOfCinema> operationsServicable;

    @GetMapping
    public String adminPlatform(Model model){
        model.addAttribute("operation" , new OperationOfCinema());
        model.addAttribute("operations" , operationsServicable.getAll());
        return "admin/operations/list";
    }


}
