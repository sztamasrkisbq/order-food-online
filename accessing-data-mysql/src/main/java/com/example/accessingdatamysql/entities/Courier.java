package com.example.accessingdatamysql.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "courier")
public class Courier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Courier_Id")
    private Integer courierId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Column(name = "Phone_Number")
    private String phoneNumber;

    @Override
    public String toString() {
        return "Courier{" +
                "courierId=" + courierId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public Integer getCourierId() { return courierId; }
    public void setCourierId(Integer courierId) { this.courierId = courierId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhonenumber() { return phoneNumber; }
    public void setPhonenumber(String phonenumber) { this.phoneNumber = phonenumber; }

}
