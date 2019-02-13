package com.cinema.controllers.adminControllers;

import com.cinema.entities.Discount;
import com.cinema.services.UserDetailsServiceImpl;
import com.cinema.services.interfaces.Servicable;
import com.cinema.validators.DiscountValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


@Controller
@RequestMapping("/admin/discounts")
public class DiscountController {
    private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class.getName());

    @Autowired
    private Servicable<Discount> discountServicable;

    @Autowired
    private DiscountValidator discountValidator;

    @GetMapping
    public String adminPlatform(Model model){
        model.addAttribute("errorMessage" , "" );
        model.addAttribute("discounts" , discountServicable.getAll());
        model.addAttribute("discount" , new Discount());
        return "admin/discounts/list";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){
        discountServicable.delete(id);
        return "redirect:/admin/discounts";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("discount") Discount discount,
                      @RequestParam("discountDate") String sessionDate,
                      BindingResult bindingResult , Model model){

        java.sql.Date sqlDate;
        try {
            Date date =new SimpleDateFormat("dd-MM-YYYY").parse(sessionDate);
            sqlDate = new java.sql.Date(date.getTime());

        } catch (ParseException e) {
            model.addAttribute("errorMessage" , "Error type of date ");
            model.addAttribute("discounts" , discountServicable.getAll());
            return "/admin/discounts/list";
        }

        discountValidator.validate(discount,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("discounts" , discountServicable.getAll());
            return "admin/discounts/list";
        }

        discount.setEndDate(sqlDate);
        discountServicable.add(discount);
        return "redirect:/admin/discounts";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id , Model model){
        model.addAttribute("errorMessage" , "");
        model.addAttribute("discount" , discountServicable.getElementById(id));
        return "/admin/discounts/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") int id ,
                         @RequestParam("discountDate") String sessionDate,
                         Discount discount ,
                         BindingResult bindingResult , Model model ){


        java.sql.Date sqlDate;
        try {
            Date date =new SimpleDateFormat("dd-MM-YYYY").parse(sessionDate);
            sqlDate = new java.sql.Date(date.getTime());
        }
        catch (ParseException e) {
            model.addAttribute("errorMessage" , "Error type of date ");
            model.addAttribute("discount" , discountServicable.getElementById(id));
            return "/admin/discounts/edit";
        }


            discountValidator.validate(discount,bindingResult);
            if(bindingResult.hasErrors()){
            model.addAttribute("discount" , discount);
            return "admin/discounts/edit";
        }

        discount.setEndDate(sqlDate);
        discountServicable.update(discount);
        return "redirect:/admin/discounts";
    }



}
