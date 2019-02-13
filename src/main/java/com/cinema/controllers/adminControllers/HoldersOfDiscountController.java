package com.cinema.controllers.adminControllers;

import com.cinema.entities.Discount;
import com.cinema.entities.HoldersOfDiscount;
import com.cinema.entities.User;
import com.cinema.services.interfaces.Servicable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/holders")
public class HoldersOfDiscountController {

    @Autowired
    @Qualifier(value = "holdersOfDiscountService")
    private Servicable<HoldersOfDiscount> holderServicable;

    @Autowired
    @Qualifier(value = "userService")
    private Servicable<User> userServicable;

    @Autowired
    @Qualifier(value = "discountService")
    private Servicable<Discount> discountServicable;

    @GetMapping
    public String adminPlatform(Model model){
        model.addAttribute("holder" , new HoldersOfDiscount());
        model.addAttribute("holders" , holderServicable.getAll());
        model.addAttribute("users" , userServicable.getAll());
        model.addAttribute("discounts" , discountServicable.getAll());
        return "admin/holders/list";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){
        holderServicable.delete(id);
        return "redirect:/admin/holders";
    }


    @PostMapping("/add")
    public String add(@ModelAttribute("holder") HoldersOfDiscount holder,
                      @RequestParam("discounts") String discount,
                      @RequestParam("users") String user){

        Discount discount_el = discountServicable.getElementById(Integer.parseInt(discount));
        holder.setDiscount(discount_el);

        User user_el = userServicable.getElementById(Integer.parseInt(user));
        holder.setUser(user_el);

        holderServicable.add(holder);
        return "redirect:/admin/holders";
    }

}
