package com.cinema.controllers.adminControllers;

import com.cinema.entities.CinemaHall;
import com.cinema.entities.Film;
import com.cinema.entities.Session;
import com.cinema.services.interfaces.FunctionServicable;
import com.cinema.services.interfaces.Servicable;
import com.cinema.validators.SessionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin/sessions")
public class SessionController  {
    private static final Logger logger = Logger.getLogger(SessionController.class.getName());
    @Autowired
    @Qualifier(value = "sessionService")
    private Servicable<Session> sessionServicable;

    @Autowired
    @Qualifier(value = "cinemaHallService")
    private FunctionServicable<CinemaHall> cinemaHallServicable;

    @Autowired
    @Qualifier(value = "filmService")
    private FunctionServicable<Film> filmServicable;

    @Autowired
    private SessionValidator sessionValidator;

    @GetMapping
    public String adminPlatform(Model model){
        model.addAttribute("session" , new Session());
        model.addAttribute("sessions" , sessionServicable.getAll());
        model.addAttribute("cinemaHalls" , cinemaHallServicable.getAll());
        model.addAttribute("films" , filmServicable.getAll());
        return "admin/sessions/list";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){
        sessionServicable.delete(id);
        return "redirect:/admin/sessions";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("session") Session session,
                      @RequestParam("films") String filmName,
                      @RequestParam("halls") String hallName,
                      @RequestParam("sessionDate") String sessionDate,
                      BindingResult bindingResult,
                      Model model){




        sessionValidator.validate(session , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("sessions" , sessionServicable.getAll());
            model.addAttribute("cinemaHalls" , cinemaHallServicable.getAll());
            model.addAttribute("films" , filmServicable.getAll());
            return "/admin/sessions/list";
        }

        java.sql.Date sqlDate;
        try {
            Date date =new SimpleDateFormat("DD-MM-YYYY HH:mm:ss").parse(sessionDate);
            sqlDate = new java.sql.Date(date.getTime());

        } catch (ParseException e) {
            model.addAttribute("sessions" , sessionServicable.getAll());
            model.addAttribute("cinemaHalls" , cinemaHallServicable.getAll());
            model.addAttribute("films" , filmServicable.getAll());
            return "/admin/sessions/list";
        }

        session.setDate(sqlDate);
        Film film = filmServicable.findByName(filmName);
        CinemaHall cinemaHall = cinemaHallServicable.findByName(hallName);
        session.setFilm(film);
        session.setCinemaHall(cinemaHall);

        sessionServicable.add(session);
        return "redirect:/admin/sessions";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id , Model model){
        model.addAttribute("session" , sessionServicable.getElementById(id));
        model.addAttribute("cinemaHalls" , cinemaHallServicable.getAll());
        model.addAttribute("films" , filmServicable.getAll());
        return "/admin/sessions/edit";
    }

    @PostMapping("/update/{id}")
    public String update(
                         @PathVariable("id") int id ,
                         @ModelAttribute("session") Session session ,
                         @RequestParam("films") String filmName ,
                         @RequestParam("halls") String hallName,
                         @RequestParam("sessionDate") String sessionDate,
                         BindingResult bindingResult , Model model){


        sessionValidator.validate(session , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("session" , session);
            model.addAttribute("cinemaHalls" , cinemaHallServicable.getAll());
            model.addAttribute("films" , filmServicable.getAll());
            return "/admin/sessions/edit";
        }

        java.sql.Date sqlDate;
        try {
            Date date =new SimpleDateFormat("DD-MM-YYYY").parse(sessionDate);
            sqlDate = new java.sql.Date(date.getTime());

        } catch (ParseException e) {
            model.addAttribute("sessions" , sessionServicable.getAll());
            model.addAttribute("cinemaHalls" , cinemaHallServicable.getAll());
            model.addAttribute("films" , filmServicable.getAll());
            return "/admin/sessions/edit";
        }

        session.setDate(sqlDate);
        Film film = filmServicable.findByName(filmName);
        CinemaHall cinemaHall = cinemaHallServicable.findByName(hallName);
        session.setFilm(film);
        session.setCinemaHall(cinemaHall);

        sessionServicable.update(session);
        return "redirect:/admin/sessions";
    }

}
