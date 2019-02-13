package com.cinema.controllers.adminControllers;

import com.cinema.entities.CinemaHall;
import com.cinema.entities.Place;
import com.cinema.services.interfaces.FunctionServicable;
import com.cinema.services.interfaces.Servicable;
import com.cinema.validators.PlaceValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/places")
public class PlaceController {

    @Autowired
    @Qualifier(value = "placeService")
    private Servicable<Place> placeServicable;

    @Autowired
    @Qualifier(value = "cinemaHallService")
    private FunctionServicable<CinemaHall> cinemaHallServicable;

    @Autowired
    @Qualifier(value = "placeValidator")
    private PlaceValidator placeValidator;

    @GetMapping
    public String adminPlatform(Model model){
        model.addAttribute("place" , new Place());
        model.addAttribute("places" , placeServicable.getAll());
        model.addAttribute("halls" , cinemaHallServicable.getAll());
        return "admin/places/list";
    }

    @PostMapping("/remove/{id}")
    public String removeFilm(@PathVariable("id") int id){
        placeServicable.delete(id);
        return "redirect:/admin/places";
    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute("place") Place place,
                          @RequestParam("halls") String hall,
                          BindingResult bindingResult,Model model){

        CinemaHall cinemaHall_el = cinemaHallServicable.findByName(hall);
        place.setCinemaHall(cinemaHall_el);
        placeValidator.validate(place , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("places" , placeServicable.getAll());
            model.addAttribute("halls" , cinemaHallServicable.getAll());
            return "/admin/places/list";
        }


        placeServicable.add(place);
        return "redirect:/admin/places";
    }

    @GetMapping("/update/{id}")
    public String updateFilm(@PathVariable("id") int id , Model model){
        model.addAttribute("place" , placeServicable.getElementById(id));
        model.addAttribute("halls" , cinemaHallServicable.getAll());
        return "admin/places/edit";
    }

    @PostMapping("/update/{id}")
    public String updateFilm(@PathVariable("id") int id ,
                             @ModelAttribute("place") Place place,
                             @RequestParam("halls") String hall,
                             BindingResult bindingResult,Model model){


        CinemaHall cinemaHall_el = cinemaHallServicable.findByName(hall);
        place.setCinemaHall(cinemaHall_el);
        placeValidator.validate(place , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("place" , place);
            model.addAttribute("places" , placeServicable.getAll());
            model.addAttribute("halls" , cinemaHallServicable.getAll());
            return "/admin/places/edit";
        }


        placeServicable.update(place);
        return "redirect:/admin/places";
    }

}
