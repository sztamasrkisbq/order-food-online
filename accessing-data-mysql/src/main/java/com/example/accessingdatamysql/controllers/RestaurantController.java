package com.example.accessingdatamysql.controllers;

import com.example.accessingdatamysql.beans.FoodBean;
import com.example.accessingdatamysql.beans.MenuBean;
import com.example.accessingdatamysql.beans.RestaurantBean;
import com.example.accessingdatamysql.entities.Food;
import com.example.accessingdatamysql.entities.Menu;
import com.example.accessingdatamysql.entities.Restaurant;
import com.example.accessingdatamysql.repositories.FoodRepository;
import com.example.accessingdatamysql.repositories.MenuRepository;
import com.example.accessingdatamysql.repositories.RestaurantRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Controller
@RequestMapping(path="/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private MenuRepository menuRepository;


    @PostMapping(path="/register")
    public @ResponseBody Boolean addRestaurant(@RequestBody RestaurantBean rbean)
    {
        System.out.println(rbean.toString());
        if(restaurantRepository.save(rbean.toEntity())!=null)
        {
            return true;
        }
        else {
            return false;
        }
    }

    @GetMapping(path="/login")
    public @ResponseBody RestaurantBean getRestaurant(@RequestParam(value = "mail") String mail,@RequestParam(value = "pwd") String pwd) {
        RestaurantBean r=new RestaurantBean(restaurantRepository.findByEmailAndPassword(mail,pwd));
        r.setMenu(getAllMenuById(r.getId()));
        for(MenuBean m:r.getMenu()) {
            m.setFoods(getAllFoodById(m.getId()));
        }
        return r;
    }

    public  RestaurantBean getRestaurant(Integer id) {
        return new RestaurantBean(restaurantRepository.findById(id).get());
    }

    @GetMapping(path="/getRest")
    public @ResponseBody RestaurantBean getRestaurantById(@RequestParam(value = "id") Integer id) {
        return new RestaurantBean(restaurantRepository.findById(id).get());
    }

    @PostMapping("/update")
    public @ResponseBody Boolean updateRestaurant(@RequestBody RestaurantBean restaurantBean){
        if(restaurantRepository.updateRestaurantById(restaurantBean.getId(),restaurantBean.getName(),restaurantBean.getAddress(),restaurantBean.openToString(),restaurantBean.getPhonenumber(),restaurantBean.getEmail())==1)
        {
            return true;
        }
        else {
            return false;
        }
    }
    @PostMapping("/addMenu")
    public @ResponseBody Integer addMenu(@RequestBody MenuBean menuBean){
        System.out.println(menuBean.toString());
        Menu m = menuRepository.save(menuBean.toEntity(new RestaurantBean(restaurantRepository.findById(menuBean.getRestaurantid()).get()).toEntity()));
        if(m!=null){
        return m.getId();}
        else
            {
            return null;
        }
    }


    @GetMapping(path="/getMenus")
    public @ResponseBody List<MenuBean> getAllMenuById(@RequestParam(value = "id") Integer Id) {
        ArrayList<MenuBean> out=new ArrayList<>();
        List<Menu> rest=menuRepository.findAllByFK_RestaurantId(Id);
        for(Menu m:rest)
        {
            out.add(new MenuBean(m));
        }
        return out;
    }

    @GetMapping(path="/getMenu")
    public @ResponseBody MenuBean getMenu(@RequestParam(value = "id") Integer Id) {
        return new MenuBean(menuRepository.findById(Id).get());
    }

    public MenuBean getMenuInner(Integer Id) {
        return new MenuBean(menuRepository.findById(Id).get());
    }

    @GetMapping(path="/getFoods")
    public @ResponseBody List<FoodBean> getAllFoodById(@RequestParam(value = "id")Integer Id) {
        ArrayList<FoodBean> out=new ArrayList<>();
        List<Food> rest=foodRepository.findAllByFK_MenuId(Id);
        for(Food f:rest)
        {
            out.add(new FoodBean(f));
        }
        return out;
    }

    @PostMapping("/addFood")
    public @ResponseBody Integer addFood(@RequestParam(value = "restId") Integer restid,@RequestParam(value = "menuId") Integer menuid,@RequestBody FoodBean foodBean){
        Food f=foodRepository.save(foodBean.toEntity(getMenuInner(menuid).toEntity(getRestaurant(restid).toEntity())));
        if(f!=null){
        return f.getId();}
        else{
            return null;
        }
    }

    @GetMapping(path="/getFood")
    public @ResponseBody FoodBean getFood(@RequestParam(value = "id") Integer Id){
        return new FoodBean(foodRepository.findById(Id).get());
    }

    @PostMapping("/updateFood")
    public @ResponseBody Boolean updateFood(@RequestBody FoodBean foodBean){
        if(foodRepository.updateFoodById(foodBean.getId(),foodBean.getName(),foodBean.getStarttime(),foodBean.getEndtime(),foodBean.getPrice(),foodBean.getAllergens(),foodBean.getIngredients(),foodBean.getMenuid())==1)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
