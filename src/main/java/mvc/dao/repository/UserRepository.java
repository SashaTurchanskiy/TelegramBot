package mvc.dao.repository;



import mvc.dao.entity.User;
import java.sql.*;

public class UserRepository {
    public User getUserByID(long chatID) {
        DataSource dataSource = new DataSource();
        String query = "Select id, chatID, firstname, category, feedURL, interval, numberOfNews" +
                "FROM users " +
                "WHERE users.chatID='" + chatID + "'";
        try(
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)
        )
        {
            if (resultSet.next()){
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getLong("chatID"),
                        resultSet.getString("firstName"),
                        resultSet.getString("category"),
                        resultSet.getString("feedURL"),
                        resultSet.getLong("interval"),
                        resultSet.getLong("numberOfNews")
                );

                return user;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean saveUser(User user){
        DataSource dataSource = new DataSource();
        try(
                Connection con = dataSource.getConnection();
                PreparedStatement stmt = user.getId() == 0L ?
                        con.prepareStatement("INSERT INTO user (chatID,firstName,category,feedURL,interval,numberOfNews) VALUES (?,?,?,?,?,?)") :
                        con.prepareStatement("UPDATE user SET chatID=?,firstName=?, category=?, feedURL=?, interval=?,numberOfNews=? WHERE chatID=" + user.getId())
        ){

            stmt.setLong(1, user.getChatID());
            stmt.setString(2, user.getFirstname());
            stmt.setString(3, user.getCategory());
            stmt.setString(4, user.getFeedURL());
            stmt.setLong(5, user.getInterval());
            stmt.setLong(6, user.getNumberofNews());

            stmt.executeLargeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;


    }

    }


