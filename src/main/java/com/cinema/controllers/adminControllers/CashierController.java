package com.cinema.controllers.adminControllers;

import com.cinema.entities.OperationOfCinema;
import com.cinema.entities.User;
import com.cinema.services.interfaces.FunctionServicable;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/cashier_panel")
public class CashierController {

    private static final Logger logger = Logger.getLogger(CashierController.class.getName());
    @Autowired
    @Qualifier(value = "operationService")
    private Servicable<OperationOfCinema> operationServicable;
    @Autowired
    @Qualifier(value = "userService")
    private FunctionServicable<User> userServicable;

    @GetMapping
    public String cashierPanel(Model model) {

        model.addAttribute("operation" , new OperationOfCinema());
        model.addAttribute("operations" , operationServicable.getAll());
        return "admin/cashier/list";
    }

    @PostMapping("/update/{id}")
    public String updateOperation(@PathVariable("id") int id ,
                                  @RequestParam("username") String name , Model model){

        model.addAttribute("operation" , new OperationOfCinema());
        model.addAttribute("operations" , operationServicable.getAll());
        OperationOfCinema operation = operationServicable.getElementById(id);

        operation.setCashier(userServicable.findByName(name));
        operation.setStatus("Покупка");
        operationServicable.update(operation);
        return "admin/cashier/list";
    }


}
