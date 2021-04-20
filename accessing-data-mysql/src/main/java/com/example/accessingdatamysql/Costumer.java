package com.example.accessingdatamysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Costumer {

    @Id
    @GeneratedValue
    private Long id;
    private String nev;
    private int telefon;
    private String email;
    private String Cim;
    //Tipus ?
    public int TelepulesID;

    private Costumer() {};

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCim() {
        return Cim;
    }

    public void setCim(String cim) {
        Cim = cim;
    }
}
