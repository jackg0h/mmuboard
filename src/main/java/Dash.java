import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Hii on 8/30/15.
 */
public abstract class Dash extends JFrame {
    private JLabel usernameLabel;
    private JList jLeftList, jMiddleList, jRightList;
    private JButton jButton;
    public Dash() {
        initComponents();
    }
    private void initComponents() {

        usernameLabel = new JLabel("Testing BOyz");
        jButton = new JButton("Testing");
        JSplitPane innerSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JSplitPane outerSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel leftPanel = new JPanel();
        JPanel middlePanel = new JPanel();
        JPanel rightPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        middlePanel.setLayout(new BoxLayout(middlePanel, BoxLayout.Y_AXIS));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
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
//        leftPanel.add(btn);
        jLeftList = new JList(Subject.getSubjects());
        jLeftList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jLeftList.setLayoutOrientation(JList.VERTICAL);
        jLeftList.setVisibleRowCount(-1);
        JScrollPane leftListScroller = new JScrollPane(jLeftList);
        leftListScroller.setPreferredSize(new Dimension(150, 80));
        JButton addSubjectBtn = new JButton("Add Subject");
        leftPanel.add(addSubjectBtn, BorderLayout.SOUTH);

        jMiddleList = new JList(Topic.getTopicsBySubjectId(1));
        jMiddleList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jMiddleList.setLayoutOrientation(JList.VERTICAL);
        jMiddleList.setVisibleRowCount(-1);
        JScrollPane middleListScroller = new JScrollPane(jMiddleList);
        middleListScroller.setPreferredSize(new Dimension(375, 80));
        JButton addTopicBtn = new JButton("Add Topic");
        middlePanel.add(addTopicBtn, BorderLayout.SOUTH);

        jRightList = new JList(Post.getPostByTopicId(1));
        jRightList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jRightList.setLayoutOrientation(JList.VERTICAL);
        jRightList.setVisibleRowCount(-1);
        jRightList.setCellRenderer(new PostRenderer());
        JScrollPane rightListScroller = new JScrollPane(jRightList);
        JButton addPostBtn = new JButton("Add Reply");
        rightPanel.add(addPostBtn, BorderLayout.SOUTH);

        jLeftList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    Subject subject = (Subject) ((JList) e.getSource())
                            .getSelectedValue();
                    jMiddleList.setModel(Topic.getTopicsBySubjectId(subject.getSubjectId()));
                    jMiddleList.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            if(e.getValueIsAdjusting()) {
                                Topic topic = (Topic) ((JList) e.getSource())
                                        .getSelectedValue();
                                jRightList.setModel(Post.getPostByTopicId(topic.getTopicId()));
                                rightPanel.invalidate();
                                rightPanel.repaint();
                            }
                        }
                    });
                    middlePanel.invalidate();
                    middlePanel.repaint();
                }
            }
        });
        leftPanel.add(leftListScroller);
        middlePanel.add(middleListScroller);
        rightPanel.add(rightListScroller);
        innerSplitPane.setLeftComponent(leftPanel);
        innerSplitPane.setRightComponent(middlePanel);
        outerSplitPane.setLeftComponent(innerSplitPane);
        outerSplitPane.setRightComponent(rightPanel);
        add(outerSplitPane, BorderLayout.CENTER);

    }
}
