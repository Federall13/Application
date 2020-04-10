
import java.net.URL;
import java.sql.*;

public class Connector {
    private Connection connection = null;
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false ";


    public connection getConneсtion() throws SQLException {
        String USERNAME = "root";
        String PASSWORD = "18111992";

        try {
            System.out.println("Устанавливаем соединение с базой");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            System.out.println("Закрыли соединение с базой");
        }
    }return ;

}

