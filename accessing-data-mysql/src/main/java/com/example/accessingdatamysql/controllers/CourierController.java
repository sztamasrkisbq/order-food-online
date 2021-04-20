package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.beans.CourierBean;
import com.example.accessingdatamysql.beans.CustomerBean;
import com.example.accessingdatamysql.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
@RequestMapping("/courier")
public class CourierController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private CourierRepository courierRepository;

    @PostMapping(path="/register")
    public @ResponseBody
    Boolean addCourier(@RequestBody CourierBean courierBean)
    {
        System.out.println(courierBean.toString());
        if(courierRepository.save(courierBean.toEntity())!=null)
        {
            return true;
        }
        else {
            return false;
        }
    }

    @GetMapping(path="/login")
    public @ResponseBody CourierBean getCourier(@RequestParam(name = "mail") String mail, @RequestParam(name = "pwd") String pwd) {
        CourierBean b=new CourierBean(courierRepository.findByEmailAndPassword(mail,pwd));
        System.out.println(b.toString());
        return b;
    }
}
