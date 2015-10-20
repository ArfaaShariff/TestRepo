

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import customcomponent.SearchTextBox;
import javafx.scene.control.ListView;
import paddy.domain.Music;
import paddy.service.MusicServices;

/**
 * @author Patrick
 */

var listMusic;

var seqMusic:Music[];

var musicServices:MusicServices = MusicServices{};

Stage {
    title: "Application title"
    width: 600
    height: 250
    scene: Scene {

        content: [
            Text {
                font: Font {
                    size: 16
                }
                x: 10
                y: 30
                content: "Search DB"
            }
            SearchTextBox {
                translateX: 10
                translateY: 40
                onResetSearch: function () {
                    println("reset !");
                        delete seqMusic;
                    }
                onSearch: function (s: String) {
                    println("Search of : {s}");

                    listMusic = musicServices.getArtisteNameBeginingBy(s);
                    delete seqMusic;
                    seqMusic = listMusic.toArray(seqMusic);

                    }
            }
            ListView {
                layoutY: 75
                width: 575
                height: 100
                items: bind seqMusic
            }
        ]
    }
}