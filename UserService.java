import java.sql.SQLException;

public class UserService {

    public void addUser() throws SQLException {
        Connector connector = new Connector();
        try {
            connector.getConneсtion().prepareStatement("select * from user");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connector.;

        }

    }

}


