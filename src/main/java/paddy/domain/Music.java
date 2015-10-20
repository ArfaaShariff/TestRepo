package paddy.domain;

import javafx.fxml.FXML;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by plank-arfaa on 10/13/2015.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllAlbum", query= "select m from Music m"),
        @NamedQuery(name = "findAllAlbumWhereArtisteLike",query="select m from Music m where m.artisteName like :param")
})
public class Music implements Serializable{

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtisteName() {
        return artisteName;
    }

    public void setArtisteName(String artisteName) {
        this.artisteName = artisteName;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    @Id
    @GeneratedValue
    private Long id;
    @FXML
    @Column(name = "artist_name")
    private String artisteName;
    @FXML
    @Column(name = "album_title")
    private String albumTitle;

    public Music() {
        super();
    }
    public Music(Long id,String artisteName,String albumTitle){
        super();
        this.albumTitle=albumTitle;
        this.artisteName=artisteName;
        this.id=id;
    }


    @Override
    public String toString(){

        StringBuffer sb = new StringBuffer();
        sb.append("id : ");sb.append(id);sb.append(" ; ");
        sb.append("artisteName : ");sb.append(artisteName);sb.append(" ; ");
        sb.append("albumTitle : ");sb.append(albumTitle);
        sb.append(" \n");

        return sb.toString();

    }
}
