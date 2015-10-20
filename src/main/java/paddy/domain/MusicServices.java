package paddy.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by plank-arfaa on 10/13/2015.
 */
public class MusicServices {
    EntityManagerFactory emf;
    EntityManager em;

    public MusicServices(){
        emf = Persistence.createEntityManagerFactory("MusicAndLight");
        em = emf.createEntityManager();
    }

    public List<Music> findAll(){

        Query query = em.createNamedQuery("findAllAlbum");
        List<Music> musics = query.getResultList();

        return musics;
    }


    public List<Music> getArtisteNameBeginningBy(String begining){

        String param = begining+"%";

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Music> query = cb.createQuery(Music.class);

        Root<Music> music = query.from(Music.class);
        query.where(cb.like(music.<String>get("artisteName"), param));
        List<Music> musics = em.createQuery(query).getResultList();

        return musics;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            em.close();
            emf.close();
        } finally {
            super.finalize();
        }
    }
}
