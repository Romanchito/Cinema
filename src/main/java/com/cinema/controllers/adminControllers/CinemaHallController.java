package com.cinema.controllers.adminControllers;

import com.cinema.entities.CinemaHall;
import com.cinema.entities.Place;
import com.cinema.services.interfaces.FunctionServicable;
import com.cinema.services.interfaces.Servicable;
import com.cinema.validators.CinemaHallValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/cinema_halls")
public class CinemaHallController {

    @Autowired
    @Qualifier(value = "cinemaHallService")
    private FunctionServicable<CinemaHall> cinemaHallServicable;

    @Autowired
    private CinemaHallValidator cinemaHallValidator;
    @Autowired
    @Qualifier(value = "placeService")
    private Servicable<Place> placeServicable;


    @GetMapping
    public String adminPlatform(Model model){
        model.addAttribute("cinemaHall" ,  new CinemaHall());
        model.addAttribute("cinema_halls" , cinemaHallServicable.getAll());
        return "admin/cinemaHalls/list";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){
        cinemaHallServicable.delete(id);
        return "redirect:/admin/cinema_halls";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("cinemaHall") CinemaHall cinemaHall ,
                      BindingResult bindingResult , Model model){

        cinemaHallValidator.validate(cinemaHall , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("cinema_halls" , cinemaHallServicable.getAll());
            return "admin/cinemaHalls/list";
        }
        cinemaHallServicable.add(cinemaHall);
        addPlaces(cinemaHall);

        return "redirect:/admin/cinema_halls";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id , Model model){
        model.addAttribute("cinemaHall" , cinemaHallServicable.getElementById(id));
        return "/admin/cinemaHalls/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id ,
                         @ModelAttribute("cinemaHall") CinemaHall cinemaHall,
                         BindingResult bindingResult , Model model){

        cinemaHallValidator.validate(cinemaHall , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("cinemaHall" , cinemaHall);
            return "admin/cinemaHalls/edit";
        }

        cinemaHallServicable.update(cinemaHall);
        return "redirect:/admin/cinema_halls";
    }

    private void addPlaces(CinemaHall cinemaHall){

        for(int i = 1; i<=cinemaHall.getCountOfRows() ; i++){
            for(int a = 1; a<=cinemaHall.getCountOfPlaces() ; a++){
                placeServicable.add(new Place(i,a,"Свободно",cinemaHall));
            }
        }


    }
}
