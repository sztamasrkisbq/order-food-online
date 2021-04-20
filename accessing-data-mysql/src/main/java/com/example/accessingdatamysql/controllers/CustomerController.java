package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.beans.CustomerBean;
import com.example.accessingdatamysql.beans.FoodBean;
import com.example.accessingdatamysql.beans.MenuBean;
import com.example.accessingdatamysql.beans.RestaurantBean;
import com.example.accessingdatamysql.entities.Food;
import com.example.accessingdatamysql.entities.Menu;
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
    public @ResponseBody CustomerBean getCustomer(@RequestParam(name = "mail") String mail, @RequestParam(name = "pwd") String pwd) {
        CustomerBean b=new CustomerBean(customerRepository.findByEmailAndPassword(mail,pwd));
        System.out.println(b.toString());
        return b;
    }
    @GetMapping("/getFoods")
    public List<MenuBean> getFoodByRestId(@RequestParam(name ="restId")Integer restId){
        ArrayList<MenuBean> out=new ArrayList<>();
        Iterable<Menu> rest=menuRepository.findAllByFK_RestaurantId(restId);
        for(Menu m:rest){
            MenuBean menuB=new MenuBean(m);
            Iterable<Food> food=foodRepository.findAllByFK_MenuId(m.getId());
            for (Food f:food){
                menuB.addFood(new FoodBean(f));
            }
            out.add(menuB);
        }
        return out;
    }
}
