package no.hib.dat104.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "fest", name = "deltaker")
public class Deltaker {
    @Id
    private String mob;
    private String fname;
    private String lname;
    private String kjoen;
    private Boolean betalt;

    public Deltaker() {
        this.mob = "";
        this.fname = "";
        this.lname = "";
        this.kjoen = "";
        this.betalt = false;

    }

    public Deltaker(String mob, String fname, String lname, String kjoen, Boolean betalt) {
        this.mob = mob;
        this.fname = fname;
        this.lname = lname;
        this.kjoen = kjoen;
        this.betalt = betalt;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getKjoen() {
        return kjoen;
    }

    public void setKjoen(String kjoen) {
        this.kjoen = kjoen;
    }

    public Boolean getBetalt() {
        return betalt;
    }

    public void setBetalt(Boolean betalt) {
        this.betalt = betalt;
    }

}