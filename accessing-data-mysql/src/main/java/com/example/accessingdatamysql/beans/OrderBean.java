package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Courier;
import com.example.accessingdatamysql.entities.Customer;
import com.example.accessingdatamysql.entities.Food;
import com.example.accessingdatamysql.entities.Order;
import com.example.accessingdatamysql.repositories.FoodRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OrderBean {
    private Integer id;
    private String name;
    private String phonenumber;
    private String email;
    private String address;
    private String description;
    private Customer customer;
    private Courier courier;
    private Map<Food,Integer> open;

    private FoodRepository foodRepository;

    private Map<Food,Integer>getOpen(String open){
        //System.out.println(open);
        Map<Food,Integer> map =new HashMap<>();
        String[] days=open.split("\\|");
        for(String s:days)
        {
            //System.out.println(s);
            String[] splits=s.split("_");
            Food food;
            food = foodRepository.findById(Integer.parseInt(splits[0])).get();
            map.put(food,Integer.parseInt(splits[1]));
        }
        return map;
    }


    public OrderBean() {
    }

    public OrderBean(Integer id, String name, String phonenumber, String email, String address, String description, Customer customer, Courier courier) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
        this.description = description;
        this.customer = customer;
        this.courier = courier;
    }
    public OrderBean(Order o){
        id = o.getId();
        this.name = o.getName();
        this.phonenumber = o.getPhone();
        this.email = o.getEmail();
        this.address = o.getAddress();
        this.description = o.getAddress();
        this.customer = o.getCustomer();
        this.courier = o.getCourier();

    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                ", courier=" + courier +
                '}';
    }
    public Order toEntity(){
        Order o = new Order();
        if(id != null){
            o.setId(this.id);
        }
        o.setName(this.name);
        o.setPhone(this.phonenumber);
        o.setEmail(this.email);
        o.setAddress(this.address);
        o.setDescription(this.description);
        o.setCustomer(this.customer);
        o.setCourier(this.courier);
        return o;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Courier getCourier() {return courier; }
    public void setCourier(Courier courier) { this.courier = courier; }
}
