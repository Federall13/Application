import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class UserService {

    public void addUser() throws SQLException, IOException {
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

    public void updateUser() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Connector connector = new Connector();
        Connection dbConnection = connector.getConneсtion();
        if (dbConnection == null) {
            System.out.println("Нет соединения, отсутствует подключение к БД");
            System.exit(0);
        }
        System.out.println("Введите номер пользователя которого хотите изменить");
        int id = Integer.parseInt(reader.readLine());
        System.out.println("Введите новое имя");
        String name = reader.readLine();
        System.out.println("Введите новую фамилию");
        String lname = reader.readLine();
        PreparedStatement preparedStatement1 = dbConnection.prepareStatement("UPDATE user SET name = ?,lname = ? WHERE id = ?");
        preparedStatement1.setString(1, name);
        preparedStatement1.setString(2, lname);
        preparedStatement1.setInt(3, id);
        preparedStatement1.executeUpdate();
        dbConnection.close();
    }

    public void deleteUser() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Connector connector = new Connector();
        Connection dbConnection = connector.getConneсtion();
        if (dbConnection == null) {
            System.out.println("Нет соединения, отсутствует подключение к БД");
            System.exit(0);
        }
        System.out.println("Введите пользователя которого хотите удалить");
        PreparedStatement preparedStatement1 = dbConnection.prepareStatement("DELETE FROM user WHERE id = ?");
        int id = Integer.parseInt(reader.readLine());
        preparedStatement1.setInt(1, id);
        preparedStatement1.executeUpdate();
        dbConnection.close();
    }

    public void printAllUser() throws SQLException {
        Connector connector = new Connector();
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
            }
            System.out.println();
        }
        dbConnection.close();
    }

}