import javax.swing.*;
import javax.swing.text.html.ListView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.Observable;

/**
 * Created by Hii on 8/30/15.
 */
public class Subject {
    private int subjectId;
    private String subjectName;
    private String subjectDescription;
    public int getSubjectId() {
        return this.subjectId;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public String toString() {
        return MessageFormat.format("{0}", this.getSubjectName());
    }

    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    static public ListModel getSubjects() {
        DefaultListModel model = new DefaultListModel();
        Connection conn = DBConnection.ConnectDb();

        try {
            PreparedStatement e = conn.prepareStatement("SELECT * FROM `subject`");
            ResultSet rs = e.executeQuery();

            while(rs.next()) {
                String subjectName = rs.getString("name");
                int subjectId = rs.getInt("id");
                Subject subject = new Subject(subjectId, subjectName);
                model.addElement(subject);
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return model;
    }
    static public boolean create(String subjectName, String subjectDescription) {
        Connection conn = DBConnection.ConnectDb();
        try {
            String insertTableSQL = "INSERT INTO subject"
                    + "(name, description, user_id) VALUES"
                    + "(?,?,?)";
            PreparedStatement pst = conn.prepareStatement(insertTableSQL);
            pst.setString(1, subjectName);
            pst.setString(2, subjectDescription);
            pst.setInt(3, 1);
            pst.executeUpdate();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
