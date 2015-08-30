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

    public Topic(int topicId, String topicTitle) {
        this.topicId = topicId;
        this.topicTitle = topicTitle;
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
        return MessageFormat.format("{0}",
                // getSubjectId(),
                getTopicTitle());
    }

    public static ListModel getTopicsById(int subjectId) {

        DefaultListModel<Topic> model = new DefaultListModel<>();

        Connection conn = DBConnection.ConnectDb();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM `topic` where subject_id="+ subjectId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String topicTitle = rs.getString("title");
                int topicId = rs.getInt("id");
                Topic topicInfo = new Topic(topicId, topicTitle);
                model.addElement(topicInfo);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
