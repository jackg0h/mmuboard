import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Hii on 8/30/15.
 */
public class User {

    public static int user_id;

    String validate_login(String username, String password) {
        try {
            Connection conn = DBConnection.ConnectDb();
            PreparedStatement pst = conn.prepareStatement("select * from user where username=? and password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String user_type = rs.getString("user_type");
                user_id = rs.getInt("id");
                return user_type;
            } else {
                return "false";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
    boolean create (String name, String username,String email, String password) {
        try {
            Connection conn = DBConnection.ConnectDb();
            String insertTableSQL = "INSERT INTO user"
                    + "(name, username, email, password) VALUES"
                    + "(?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(insertTableSQL);
            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, email);
            pst.setString(4, password);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
