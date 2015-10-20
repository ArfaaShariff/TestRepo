package paddy.domain;

/**
 * Created by plank-arfaa on 10/13/2015.
 */




    import java.net.URL;
    import java.util.List;
    import javax.persistence.EntityManager;
    import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;
    import javax.persistence.Query;
    import javax.persistence.criteria.CriteriaBuilder;
    import javax.persistence.criteria.CriteriaQuery;
    import javax.persistence.criteria.Root;

    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.stage.Stage;
    import paddy.domain.Music;

    /**
     *
     * @author Patrick
     */
    public class main extends Application {

        public static void main(String[] args) throws Exception {
            launch(args);


            EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAndLight");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            Music musicBean = new Music();

            musicBean.setAlbumTitle(musicBean.getAlbumTitle());
            musicBean.setArtisteName(musicBean.getArtisteName());
            em.persist(musicBean);
            em.getTransaction().commit();


            //get and create the namedQuery findAllBum
            String param = "Arc%";
            Query query = em.createNamedQuery("findAllAlbumWhereArtisteLike");
            //execute the query
            query.setParameter("param", param);
            List<Music> musics = query.getResultList();

            for (Music music : musics) {
                System.out.println(music + "this is music");
            }

            System.out.println("-----------------------------------------");

//            String param = "Arc%";

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Music> query2 = cb.createQuery(Music.class);
            //select * from Music
            Root<Music> music2 = query2.from(Music.class);
            //where artisteName like param
            //in my example where artisteName like Arc% (begining by Arc)
            query2.where(cb.like(music2.<String>get("artisteName"), param));
            //execute the query
            List<Music> musics2 = em.createQuery(query2).getResultList();

            for (Music music : musics2) {
                System.out.println(music);
            }

            em.close();
            emf.close();


        }
        @Override
        public void start(Stage primaryStage) throws Exception {
//            URL location = getClass().getClassLoader().getResource("sample.fxml");
//
//            FXMLLoader fxmlLoader = new FXMLLoader();
//            fxmlLoader.setLocation(location);
//
//            Parent root = (Parent)fxmlLoader.load();
//            Controller controller = (Controller)fxmlLoader.getController();
//            primaryStage.show();
//            primaryStage.setTitle("Music");

            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample.fxml"));
            Parent root = (Parent)loader.load();
            Controller controller= loader.getController();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
//
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();


        }
    }


