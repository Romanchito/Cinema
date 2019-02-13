package com.cinema.controllers.adminControllers;

import com.cinema.entities.Film;
import com.cinema.entities.Images;
import com.cinema.services.interfaces.Servicable;
import com.cinema.validators.FilmValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/films")
public class FilmController {

    @Autowired
    @Qualifier(value = "filmService")
    private Servicable<Film> filmServicable;

    @Autowired
    private FilmValidator filmValidator;

    @Autowired
    @Qualifier(value = "imageService")
    private Servicable<Images> imagesServicable;

    @GetMapping
    public String adminPlatform(Model model){
        model.addAttribute("film" , new Film());
        model.addAttribute("films" , filmServicable.getAll());
        model.addAttribute("images" , imagesServicable.getAll());
        return "admin/films/list";
    }

    @PostMapping("/remove/{id}")
    public String removeFilm(@PathVariable("id") int id){
        filmServicable.delete(id);
        return "redirect:/admin/films";
    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute("film") Film film ,
                          @RequestParam("images") String image,
                          BindingResult bindingResult ,
                          Model model){

        filmValidator.validate(film , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("films" , filmServicable.getAll());
            model.addAttribute("images" , imagesServicable.getAll());
            return "admin/films/list";
        }
        int imageId = Integer.parseInt(image);
        film.setImage(imagesServicable.getElementById(imageId));
        filmServicable.add(film);
        return "redirect:/admin/films";
    }

    @GetMapping("/update/{id}")
    public String updateFilm(@PathVariable("id") int id , Model model){
        model.addAttribute("film" , filmServicable.getElementById(id));
        model.addAttribute("images" , imagesServicable.getAll());
        return "admin/films/edit";
    }

    @PostMapping("/update/{id}")
    public String updateFilm(@PathVariable("id") int id,
                             @ModelAttribute("film") Film film,
                             @RequestParam("images") String image,
                             BindingResult bindingResult ,
                             Model model){

        filmValidator.validate(film , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("film" , film);
            model.addAttribute("images" , imagesServicable.getAll());
            return "admin/films/edit";
        }

        int imageId = Integer.parseInt(image);
        film.setImage(imagesServicable.getElementById(imageId));
        filmServicable.update(film);
        return "redirect:/admin/films";
    }

}
