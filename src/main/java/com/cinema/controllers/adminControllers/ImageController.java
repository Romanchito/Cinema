package com.cinema.controllers.adminControllers;


import com.cinema.entities.Images;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/images")
public class ImageController {

    @Autowired
    @Qualifier(value = "imageService")
    private Servicable<Images> imagesServicable;

    @GetMapping
    public String adminPlatform(Model model){
        model.addAttribute("image" , new Images());
        model.addAttribute("images" , imagesServicable.getAll());
        return "admin/images/list";
    }

    @PostMapping("/remove/{id}")
    public String removeFilm(@PathVariable("id") int id){
        imagesServicable.delete(id);
        return "redirect:/admin/images";
    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute("image") Images image){
        imagesServicable.add(image);
        return "redirect:/admin/images";
    }

    @GetMapping("/update/{id}")
    public String updateFilm(@PathVariable("id") int id , Model model){
        model.addAttribute("image" , imagesServicable.getElementById(id));
        return "admin/images/edit";
    }

    @PostMapping("/update")
    public String updateFilm(@ModelAttribute("image") Images image){
        imagesServicable.update(image);
        return "redirect:/admin/images";
    }

}
