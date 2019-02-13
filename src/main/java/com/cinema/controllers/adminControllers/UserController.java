package com.cinema.controllers.adminControllers;

import com.cinema.entities.User;
import com.cinema.services.interfaces.Servicable;
import com.cinema.validators.UserAuthValidator;
import com.cinema.validators.UserUpdateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/users")
public class UserController  {
    @Autowired
    @Qualifier(value = "userService")
    private Servicable<User> userServicable;

    @Autowired
    private UserAuthValidator authValidator;

    @Autowired
    private UserUpdateValidator userUpdateValidator;

    @GetMapping
    public String adminPlatform(Model model){

        model.addAttribute("users" , userServicable.getAll());
        model.addAttribute("user" , new User());
        return "admin/users/list";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){
        userServicable.delete(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") User user ,
                      @RequestParam("roles") String role ,
                      BindingResult bindingResult ,
                      Model model ){

        authValidator.validate(user , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("users" , userServicable.getAll());
            return "admin/users/list";
        }
        user.setRole(role);
        userServicable.add(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id , Model model){
        model.addAttribute("user" , userServicable.getElementById(id));
        return "/admin/users/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id ,
                         @ModelAttribute("user") User user ,
                         @RequestParam("roles") String role ,
                         BindingResult bindingResult , Model model){

        userUpdateValidator.validate(user , bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("user" , user);
            return "/admin/users/edit";
        }
        user.setRole(role);
        userServicable.update(user);
        return "redirect:/admin/users";
    }
}
