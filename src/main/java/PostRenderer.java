import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by Hii on 8/30/15.
 */
public class PostRenderer extends JLabel implements ListCellRenderer<Post>  {
    protected static Border noFocusBorder = new LineBorder(Color.BLACK,1,false);

    protected static TitledBorder focusBorder = new TitledBorder(LineBorder.createGrayLineBorder(),
            "title");
    @Override
    public Component getListCellRendererComponent(JList<? extends Post> list, Post post, int index, boolean isSelected, boolean cellHasFocus) {
        String postTitle = post.getPostTitle();
        String postContents = post.getPostContents();
//        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/images/" + code + ".png"));

//        setIcon(imageIcon);
//        setBorder(cellHasFocus ? focusBorder : noFocusBorder);
        setBorder(noFocusBorder);

        setText("<html><p style=\"line-height: 250%; padding: 15px; \"><b>" +
                postTitle + "</b><br>" + postContents + "</html");

        return this;
    }
}
