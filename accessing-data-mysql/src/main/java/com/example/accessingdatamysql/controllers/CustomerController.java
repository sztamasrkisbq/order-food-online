package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.beans.*;
import com.example.accessingdatamysql.entities.Food;
import com.example.accessingdatamysql.entities.Menu;
import com.example.accessingdatamysql.entities.Order;
import com.example.accessingdatamysql.entities.Restaurant;
import com.example.accessingdatamysql.repositories.*;
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
    @Autowired
    private OrderRepository orderRepository;


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

    @PostMapping(path="/addOrder")
    public @ResponseBody Integer addOrder(@RequestBody OrderBean orderBean)
    {
        Order o = orderRepository.save(orderBean.toEntity());
        if(o != null)
        {
            return o.getId();
        }
        else {
            return null;
        }
    }

    @GetMapping(path="/login")
    public @ResponseBody CustomerBean getCustomer(@RequestParam(name = "mail") String mail, @RequestParam(name = "pwd") String pwd) {
        CustomerBean b=new CustomerBean(customerRepository.findByEmailAndPassword(mail,pwd));
        System.out.println(b.toString());
        return b;
    }
    @GetMapping("/getMenus")
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
    @GetMapping("/getCust")
    public @ResponseBody CustomerBean getCust(@RequestParam(value = "id") Integer id) {
        CustomerBean b=new CustomerBean(customerRepository.findById(id).get());
        System.out.println(b.toString());
        return b;
    }

    @PostMapping("/order")
    public @ResponseBody Integer order(@RequestBody OrderBean orderBean)
    {
        System.out.println(orderBean.toString());
        Order o=orderRepository.save(orderBean.toEntity());
        if(o!=null)
        {
            return o.getId();
        }
        else {
            return null;
        }
    }



}
