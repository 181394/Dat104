package no.hib.dat104.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Statement;
import java.util.List;

@Stateless
public class DBKom {


    @PersistenceContext(name = "FestPersistenceUnit")
    private EntityManager em;

    public void meldPaa(Deltaker d){em.persist(d);}

//    public void slettVare(String mob){em.remove(em.find(Deltaker.class, mob));}

    public List<Deltaker> dliste (){
        Query query = em.createQuery("SELECT d FROM Deltaker d ORDER BY d.lname ASC", Deltaker.class);
        return query.getResultList();
    }

    public Deltaker finnDeltaker(String mob){
        return em.find(Deltaker.class, mob);
    }

    public void betal(String mob){

        Deltaker deltaker = finnDeltaker(mob);
        System.out.println(deltaker.getMob());
        deltaker.setBetalt(true);
        System.out.println(deltaker.getBetalt());
        em.persist(deltaker);

    }

    public boolean finnesDeltaker(String mob){
        return (em.find(Deltaker.class, mob) != null);
    }
}
