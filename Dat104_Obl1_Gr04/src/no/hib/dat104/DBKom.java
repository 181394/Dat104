package no.hib.dat104;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class DBKom {


    @PersistenceContext(name = "HandlelistePersistenceUnit")
    private EntityManager em;

    public void leggTilVare(Varer v){em.persist(v);}

    public void slettVare(String varenavn){em.remove(em.find(Varer.class, varenavn));}

    public List<Varer> hliste (){
        Query query = em.createQuery("SELECT v FROM Varer v", Varer.class);
        return query.getResultList();
    }

    public boolean finnesVare(String varenavn){
        if (em.find(Varer.class, varenavn) != null)
            return true;
        else
            return false;
    }
}
