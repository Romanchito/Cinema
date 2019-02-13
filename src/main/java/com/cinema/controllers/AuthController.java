package com.cinema.controllers;

import com.cinema.entities.User;
import com.cinema.services.interfaces.SecurityService;
import com.cinema.services.interfaces.FunctionServicable;
import com.cinema.validators.UserAuthValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

    @Autowired
    @Qualifier(value = "userService")
    private FunctionServicable<User> userServicable;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserAuthValidator authValidator;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm" , new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm , BindingResult bindingResult, Model model ){

        authValidator.validate(userForm , bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userServicable.add(userForm);

        securityService.autoLogin(userForm.getName() , userForm.getPassword());
        return "redirect:/HomePage";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Invalid login or password!");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }


































//    @RequestMapping("/admin")
//    public ModelAndView admin()
//    {
//        Authentication authentication = SecurityContextHolder.getContext()
//                .getAuthentication();
//
//        String welcomeMessage = "Welcome "+authentication.getName()+"!!";
//        return new ModelAndView("admin", "welcomeMessage", welcomeMessage);
//    }
//
//    @RequestMapping("/error")
//    public String error(ModelMap model)
//    {
//        model.addAttribute("error", "true");
//        return "login";
//
//    }
//
//    @RequestMapping("/login")
//    public String login()
//    {
//        return "login";
//    }
//    @RequestMapping("/logout")
//    public String logout(ModelMap model)
//    {
//        Authentication authentication = SecurityContextHolder.getContext()
//                .getAuthentication();
//        authentication.setAuthenticated(false);
//
//        model.addAttribute("logout", "true");
//        return "login";
//    }
}
