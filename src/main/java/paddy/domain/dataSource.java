package paddy.domain;

/**
 * Created by plank-arfaa on 10/14/2015.
 */
public class dataSource {
    private static dataSource ourInstance = new dataSource();

    public static dataSource getInstance() {
        return ourInstance;
    }

    private dataSource() {
    }
}
