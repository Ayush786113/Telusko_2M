package Day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    Connection connection;
    public Database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/telusko2M", "ayush", "sudo");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Product product){
        String query = "insert into products (name,type,place,warranty) values (?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, product.getName());
            statement.setString(2, product.getType());
            statement.setString(3, product.getPlace());
            statement.setInt(4, product.getWarranty());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
