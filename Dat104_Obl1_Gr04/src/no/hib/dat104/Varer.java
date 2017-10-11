package no.hib.dat104;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "handleliste", name = "varer")
public class Varer {

    @Id
    String varenavn;

    public Varer (){this.varenavn = "";}

    public Varer(String varenavn){this.varenavn = varenavn;}


    public String getVarenavn() {
        return varenavn;
    }

    public void setVarenavn(String varenavn) {
        this.varenavn = varenavn;
    }

    @Override
    public String toString() {
        return this.varenavn;
    }
}
