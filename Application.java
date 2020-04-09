
import java.sql.*;

public class Application {
// jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false"

    private static Connection connection = null; // отвечает за соединения приложения к базе данных
    private static String URL = "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false "; //jdbc:mysql://localhost/db?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false
    private static String USERNAME = "root";
    private static String PASSWORD = "18111992";

    public static void main(String[] args) throws SQLException {


        try {
            System.out.println("Устанавливаем соединение с базой");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user ");
// preparedStatement.setString(1, "Гриша");
// preparedStatement.setString(2, "Жопкин");

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

    }

}
