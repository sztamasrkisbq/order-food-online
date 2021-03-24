package com.example.accessingdatamysql.controllers;


import com.example.accessingdatamysql.beans.CustomerBean;
import com.example.accessingdatamysql.beans.RestaurantBean;
import com.example.accessingdatamysql.entities.Restaurant;
import com.example.accessingdatamysql.repositories.CustomerRepository;
import com.example.accessingdatamysql.repositories.FoodRepository;
import com.example.accessingdatamysql.repositories.MenuRepository;
import com.example.accessingdatamysql.repositories.RestaurantRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/getRestaurants")
    public @ResponseBody
    List<RestaurantBean> getAllRestaurants(){
        ArrayList<RestaurantBean> out=new ArrayList<>();
        Iterable<Restaurant> rest=restaurantRepository.findAll();
        for(Restaurant r:rest)
        {
            out.add(new RestaurantBean(r));
        }
        return out;
    }

    @PostMapping(path="/register")
    public @ResponseBody Boolean addCustomer(@RequestBody CustomerBean customerBean)
    {
        System.out.println(customerBean.toString());
        if(customerRepository.save(customerBean.toEntity())!=null)
        {
            return true;
        }
        else {
            return false;
        }
    }

    @GetMapping(path="/login")
    public @ResponseBody CustomerBean getCustomer(@RequestParam(value = "mail") String mail, @RequestParam(value = "pwd") String pwd) {
        return new CustomerBean(customerRepository.findByEmailAndPassword(mail,pwd));
    }

}
