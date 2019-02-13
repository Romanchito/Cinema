package com.cinema.controllers;

import com.cinema.entities.Film;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @Autowired
    private Servicable<Film> filmServicable;



    @GetMapping("/")
    public String allFilms(Model model){
        model.addAttribute("films" , filmServicable.getAll());
        return "HomePage";
    }

    @GetMapping("/film/{id}")
    public String filmInform(@PathVariable("id") int id , Model model){
        model.addAttribute("film" , filmServicable.getElementById(id));
        return "film";
    }


}
