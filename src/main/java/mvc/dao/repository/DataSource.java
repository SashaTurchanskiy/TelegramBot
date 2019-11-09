package mvc.dao.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource implements AutoCloseable {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/db?user=root&password=12345";

    private Connection connection = null;

    public DataSource(){
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        }catch (IllegalAccessException | InstantiationException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection(){
        try {
            if (connection != null){
                connection = DriverManager.getConnection(DB_URL);
            }
        } catch (SQLException e) {
            System.out.println("error ocurred " + e.toString());
        }
        return connection;
    }


    @Override
    public void close() throws Exception {
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
