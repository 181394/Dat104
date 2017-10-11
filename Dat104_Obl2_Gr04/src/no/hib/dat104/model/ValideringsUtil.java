package no.hib.dat104.model;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ValideringsUtil {
    private String mob;
    private String fname;
    private String lname;

    public ValideringsUtil() {

    }

    public ValideringsUtil(HttpServletRequest request) {
        mob = request.getParameter("mob");
        fname = request.getParameter("fname");
        lname = request.getParameter("lname");

    }
    public boolean erAlleGyldig() {
        return !this.erMobUgyldig() && !this.erFnameUgyldig() && !this.erLnameUgyldig();
    }
    public boolean erMobUgyldig() {
        return mob == null || mob.length() != 8;
    }
    public boolean erFnameUgyldig() {
        return fname == null || fname.length()<=2;
    }
    public boolean erLnameUgyldig() {
        return lname == null || lname.length()<=2;
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
}
