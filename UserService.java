import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class UserService {

    public static void addUser() throws SQLException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Connector connector = new Connector();
        Connection connectionUser = connector.getConneсtion();
        PreparedStatement preparedStatement = connectionUser.prepareStatement("INSERT INTO user (name, lname) VALUES (?, ?)");
        System.out.println("Введите имя");
        String name = reader.readLine();
        System.out.println("Введите фамилию");
        String lname = reader.readLine();
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lname);
        int resultSet = preparedStatement.executeUpdate();
        connectionUser.close();
    }
}