import java.sql.*;

public class UserService {

    public static void addUser() throws SQLException {
        Connector connector = new Connector();
        Connection cout =  connector.getConneсtion();
      PreparedStatement preparedStatement = cout.prepareStatement("INSERT INTO user (name, lname) VALUES (?, ?");
      preparedStatement.setString(1,"Гриша");
      preparedStatement.setString(2,"Головкин");
      int resultSet = preparedStatement.executeUpdate();
      cout.close();



    }

}


