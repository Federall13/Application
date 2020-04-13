import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class UserService {

    public static void addUser() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Connector connector = new Connector();
        Connection dbConnection = connector.getConneсtion();
        if (dbConnection == null) {
            System.out.println("Нет соединения, отсутствует подключение к БД");
            System.exit(0);
        }
        PreparedStatement preparedStatement = dbConnection.prepareStatement("INSERT INTO user (name, lname) VALUES (?, ?)");
        System.out.println("Введите имя");
        String name = reader.readLine();
        System.out.println("Введите фамилию");
        String lname = reader.readLine();
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lname);
        preparedStatement.executeUpdate();
        dbConnection.close();
    }

    public static void updateUser() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Connector connector = new Connector();
        Connection dbConnection = connector.getConneсtion();
        if (dbConnection == null) {
            System.out.println("Нет соединения, отсутствует подключение к БД");
            System.exit(0);
        }
        System.out.println("Введите пользователя");
        ;
        PreparedStatement preparedStatement1 = dbConnection.prepareStatement("UPDATE user SET name = ?,lname = ? WHERE id = ?");
        int id = Integer.parseInt(reader.readLine());
        preparedStatement1.setInt(3, id);
        System.out.println("Введите новое имя");
        String name = reader.readLine();
        preparedStatement1.setString(1, name);
        System.out.println("Введите новую фамилию");
        String lname = reader.readLine();
        preparedStatement1.setString(2, lname);
        preparedStatement1.executeUpdate();
        dbConnection.close();
    }

    public static void deleteUser() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Connector connector = new Connector();
        Connection dbConnection = connector.getConneсtion();
        if (dbConnection == null) {
            System.out.println("Нет соединения, отсутствует подключение к БД");
            System.exit(0);
        }
        System.out.println("Введите пользователя которого хотите удалить");
        ;
        PreparedStatement preparedStatement1 = dbConnection.prepareStatement("DELETE FROM user WHERE id = ?");
        int id = Integer.parseInt(reader.readLine());
        preparedStatement1.setInt(1, id);
        preparedStatement1.executeUpdate();
        dbConnection.close();
    }

    public static void printAllUser() throws SQLException {
        Connector connector = new Connector();
        try {
        Connection dbConnection = connector.getConneсtion();
        if (dbConnection == null) {
            System.out.println("Нет соединения, отсутствует подключение к БД");
            System.exit(0);
        }
        PreparedStatement preparedStatement1 = dbConnection.prepareStatement("SELECT * FROM user");
       ResultSet resultSet = preparedStatement1.executeQuery();
       int columns = resultSet.getMetaData().getColumnCount();
       while (resultSet.next()) {
           for (int i = 1; i <= columns; i++) {
               System.out.print(resultSet.getString(i) + "\t");
           } System.out.println(); }
       }
        catch (Exception exc) {
            exc.printStackTrace();
       }
        finally {
            connector.getConneсtion().close();
            System.out.println("Закрыли соединение с базой");
        }
    }
}