import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;

/**
 * Created by Hii on 8/30/15.
 */
public class Post  {
    private int postId;
    private String postTitle;
    private String postContents;

    public Post(int postId, String postTitle, String postContents) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContents = postContents;
    }

    Post() {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }
    public String getPostContents() {
        return postContents;
    }

    @Override
    public String toString() {
        return "<html><b>" + postTitle + "</b><br>" + postContents + "</html>";
    }

    public static ListModel getPostByTopicId(int topicId) {

        DefaultListModel<Post> model = new DefaultListModel<>();

        Connection conn = DBConnection.ConnectDb();
        try {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM `post` where topic_id="+ topicId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String postTitle = rs.getString("title");
                int postId = rs.getInt("id");
                Post topicInfo = new Post(postId, postTitle,rs.getString("contents"));
                model.addElement(topicInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
    }
}
