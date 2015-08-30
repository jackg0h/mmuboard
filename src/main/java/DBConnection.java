import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Hii on 8/30/15.
 */
public class DBConnection {

    Connection conn = null;
    static String user= "root";
    static String password= "root";
    static String dbname= "mmuboard";

    public static Connection ConnectDb() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname + "?user=" + user + "&password=" + password);
            //JOptionPane.showMessageDialog(null, "Connection Successful");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            //JOptionPane.showMessageDialog(null, "Connection failed, please start MySQL server.");
            return null;
        }
    }
}