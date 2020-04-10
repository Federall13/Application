
import java.sql.*;

public class Connector {


    public String getConnector() throws SQLException {
        Connection connection = null;
        String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false ";
        String USERNAME = "root";
        String PASSWORD = "18111992";

        try {
            System.out.println("Устанавливаем соединение с базой");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user ");

            ResultSet result = preparedStatement.executeQuery();

            int columns = result.getMetaData().getColumnCount();
            while (result.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(result.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            System.out.println("Закрыли соединение с базой");
        }


        return  getConnector();
    }

}




