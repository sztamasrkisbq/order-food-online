package com.example.accessingdatamysql.beans;

import com.example.accessingdatamysql.entities.Restaurant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantBean {
    private Integer id=null;
    private String name;
    private String address;
    private Map<String,String> open;
    private String phonenumber;
    private String email;
    private String password;
    private List<MenuBean> menu;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RestaurantBean(Restaurant r) {
        this.id=r.getId();
        this.name=r.getName();
        this.address=r.getAddress();
        this.open=getOpen(r.getOpen());
        this.phonenumber=r.getPhoneNum();
        this.email=r.getEmail();
        this.password=r.getPassword();


    }
    private Map<String,String>getOpen(String open){
        //System.out.println(open);
        Map<String,String> map =new HashMap<>();
        String[] days=open.split("\\|");
        for(String s:days)
        {
            //System.out.println(s);
            String[] splits=s.split("_");
            map.put(splits[0],splits[1]);
        }
        return map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, String> getOpen() {
        return open;
    }

    public void setOpen(Map<String, String> open) {
        this.open = open;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MenuBean> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuBean> menu) {
        this.menu = menu;
    }

    public String openToString(){
        String out="";
        for(Map.Entry<String,String> e:open.entrySet())
        {
            out+=e.getKey()+"_"+e.getValue()+"|";
        }
        out.replace(out.substring(out.length()),"");
        return out;
    }
    private void addMenu(MenuBean m){

        menu.add(m);
    }
    public Restaurant toEntity(){
        Restaurant r=new Restaurant();
        if(id!=null){
            r.setId(this.id);
        }
        r.setAddress(this.address);
        r.setEmail(this.email);
        r.setName(this.name);
        r.setPhoneNum(this.phonenumber);
        r.setOpen(this.openToString());
        r.setPassword(this.password);
        return r;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RestaurantBean{" +
                "Id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", open=" + open +
                ", phoneNum='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", menu=" + menu +
                '}';
    }

    public RestaurantBean() {
    }
}
