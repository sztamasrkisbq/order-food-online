package com.example.accessingdatamysql.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="Sorrend")
public class Sorrend implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Courier CourierID;

    @Column(name="EndDate")
    private String Sorrend;

    public Courier getCourierID() {
        return CourierID;
    }

    public void setCourierID(Courier courierID) {
        CourierID = courierID;
    }

    public String getSorrend() {
        return Sorrend;
    }

    public void setSorrend(String sorrend) {
        Sorrend = sorrend;
    }
}
