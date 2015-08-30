import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Hii on 8/30/15.
 */
public abstract class Dash extends JFrame {
    private JLabel usernameLabel;
    private JButton jButton;
    public Dash() {
        initComponents();
    }
    private void initComponents() {

        usernameLabel = new JLabel("Testing BOyz");
        jButton = new JButton("Testing");
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JButton btn = new JButton("Click here to login");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User();
                if ("student".equals(user.validate_login("test", "test"))) {
                    JOptionPane.showMessageDialog(null, "Detected Student!");
                } else if ("lecturer".equals(user.validate_login("test", "test"))) {
                    JOptionPane.showMessageDialog(null, "Detected Student!");
                }
            }
        });
        leftPanel.add(btn);
        JList jList = new JList(Subject.getSubjects());
        jList.setSize(leftPanel.getWidth(), jList.getHeight());
        leftPanel.add(jList);
        rightPanel.add(jButton);
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);
        add(splitPane, BorderLayout.CENTER);

    }
}
