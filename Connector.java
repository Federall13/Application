import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.*;

public class Connector {
    private Connection connection = null;
    private final String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false ";
    private final String USERNAME = "root";
    private final String PASSWORD = "18111992";

    public Connection getConneсtion() throws SQLException {

        try {
            System.out.println("Устанавливаем соединение с базой");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {
            System.out.println("Соединение не удалось получить");
            e.printStackTrace();
        } 
        return connection;
    }
}