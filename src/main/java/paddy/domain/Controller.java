package paddy.domain;

import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by plank-arfaa on 10/14/2015.
 */
public class Controller extends AnchorPane implements Initializable{



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void save(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAndLight");
        EntityManager em = emf.createEntityManager();
        em.getTransaction( ).begin( );
        Music musicBean= new Music();

        musicBean.setAlbumTitle(musicBean.getAlbumTitle());
        musicBean.setArtisteName(musicBean.getArtisteName());
        em.persist(musicBean);
        em.getTransaction().commit();


    }
}
