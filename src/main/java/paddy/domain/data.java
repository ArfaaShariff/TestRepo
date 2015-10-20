package paddy.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by plank-arfaa on 10/14/2015.
 */
public class data {
    public void data() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAndLight");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Music musicBean = new Music();
    }
}
