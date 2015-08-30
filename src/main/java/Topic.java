import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hii on 8/30/15.
 */
public class Topic {
    private int topicId;
    private String topicTitle;
    private String topicDescription;
    public Topic(int topicId, String topicTitle, String topicDescription) {
        this.topicId = topicId;
        this.topicTitle = topicTitle;
        this.topicDescription = topicDescription;
    }

    Topic() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTopicId() {
        return topicId;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    @Override
    public String toString() {
        return "<html><p style=\"line-height: 250%; padding: 15px; \"><b>" +
                topicTitle + "</b><br>" + topicDescription + "</html>";
    }

    public static ListModel getTopicsBySubjectId(int subjectId) {

        DefaultListModel<Topic> model = new DefaultListModel<>();

        Connection conn = DBConnection.ConnectDb();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM `topic` where subject_id="+ subjectId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String topicTitle = rs.getString("title");
                int topicId = rs.getInt("id");
                Topic topicInfo = new Topic(topicId, topicTitle, rs.getString("description"));
                model.addElement(topicInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
    public static boolean create(int subjectId, String topicTitle, String topicDescription) {
        Connection conn = DBConnection.ConnectDb();
        try {
            String insertTableSQL = "INSERT INTO topic"
                    + "(subject_id, title, description, user_id) VALUES"
                    + "(?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(insertTableSQL);
            pst.setInt(1, subjectId);
            pst.setString(2, topicTitle);
            pst.setString(3, topicDescription);
            pst.setInt(4, 1);
            pst.executeUpdate();
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;

        }
    }
}
