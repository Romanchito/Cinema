package com.cinema.controllers;


import com.cinema.entities.*;
import com.cinema.services.interfaces.FunctionServicable;
import com.cinema.services.interfaces.OperationServicable;
import com.cinema.services.interfaces.PlaceServicable;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

@Controller
public class OrderController {

    private static final Logger logger = Logger.getLogger(OrderController.class.getName());
    @Autowired
    @Qualifier(value = "sessionService")
    private Servicable<Session> sessionServicable;
    @Autowired
    @Qualifier(value = "cinemaHallService")
    private Servicable<CinemaHall> cinemaHallServicable;
    @Autowired
    private OperationServicable<OperationOfCinema> operationOfCinemaServicable;
    @Autowired
    @Qualifier(value = "userService")
    private  FunctionServicable<User> userFunctionServicable;
    @Autowired
    @Qualifier(value = "placeService")
    private PlaceServicable<Place> placeServicable;



    @GetMapping("/order/{id}+{id1}")
    public String addOrder(@PathVariable("id") int id ,@PathVariable("id1") int id1 , Model model){

        model.addAttribute("error" , "");
        model.addAttribute("session" , sessionServicable.getElementById(id1));
        model.addAttribute("cinemaHall" , cinemaHallServicable.getElementById(id));
        model.addAttribute("operation" , new OperationOfCinema());
        model.addAttribute("places" , placeServicable.getAll());

        return "/order/addOrder";
    }

    @PostMapping("/order/{id}+{id1}")
    public String addOrder(@PathVariable("id") int id,
                           @PathVariable("id1") int id1,
                           @ModelAttribute("operation") OperationOfCinema operation,
                           @RequestParam("row") String row ,
                           @RequestParam("username") String username ,
                           @RequestParam("place") String place, Model model ){


        int row_el = Integer.parseInt(row);
        int place_el = Integer.parseInt(place);
        if(!operationOfCinemaServicable.checkOrder(row_el, place_el , sessionServicable.getElementById(id1) )){
            model.addAttribute("error" , "Sorry , this place is bought");
            model.addAttribute("session" , sessionServicable.getElementById(id1));
            model.addAttribute("operation" , new OperationOfCinema());
            model.addAttribute("cinemaHall" , cinemaHallServicable.getElementById(id));
            model.addAttribute("places" , placeServicable.getAll());
            return "/order/addOrder";
        }


        operation.setSession(sessionServicable.getElementById(id1));
        operation.setStatus("Бронь");
        if(username != ""){
            operation.setBuyer(userFunctionServicable.findByName(username));
        }
        Random random = new Random();
        int code = random.nextInt(1000);
        operation.setCode("STX" + code);

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        operation.setDate(sqlDate);

        operation.setPlace(Integer.parseInt(place));
        operation.setRow(Integer.parseInt(row));
        logger.info("IDDDDDDDDDDDDDDDDDDDDDD " + operation.getId() );
        operationOfCinemaServicable.add(operation);

        Place order_place = placeServicable.findPlace(row_el , place_el , cinemaHallServicable.getElementById(id));
        order_place.setStatus("Занято");
        placeServicable.update(order_place);


        DateFormat format = new SimpleDateFormat("DD-MM-YYYY HH:mm:ss ");
        String updateLast = format.format(utilDate);

        model.addAttribute("code" ,code);
        model.addAttribute("row" ,row);
        model.addAttribute("place" ,place);
        model.addAttribute("username" ,username);
        model.addAttribute("date" ,updateLast);

        return "/order/orderResult";
    }



}
