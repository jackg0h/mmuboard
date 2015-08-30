import javafx.geometry.Pos;

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
//    private JLabel usernameLabel;
    private JList jSubjectList, jTopicList, jPostList;
//    private JButton jButton;
    private int current_subject = 1;
    private int current_topic = 1;
//    private int current_post = 1;

    public Dash() {
        initComponents();
    }
    private void initComponents() {

//        usernameLabel = new JLabel("Testing BOyz");
//        jButton = new JButton("Testing");
        JSplitPane innerSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JSplitPane outerSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel subjectsPanel = new JPanel();
        JPanel topicsPanel = new JPanel();
        JPanel postPanel = new JPanel();
        subjectsPanel.setLayout(new BoxLayout(subjectsPanel, BoxLayout.Y_AXIS));
        topicsPanel.setLayout(new BoxLayout(topicsPanel, BoxLayout.Y_AXIS));
        postPanel.setLayout(new BoxLayout(postPanel, BoxLayout.Y_AXIS));
//        JButton btn = new JButton("Click here to login");
//        btn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                User user = new User();
//                if ("student".equals(user.validate_login("test", "test"))) {
//                    JOptionPane.showMessageDialog(null, "Detected Student!");
//                } else if ("lecturer".equals(user.validate_login("test", "test"))) {
//                    JOptionPane.showMessageDialog(null, "Detected Student!");
//                }
//            }
//        });
//        subjectsPanel.add(btn);
        jSubjectList = new JList(Subject.getSubjects());
        jSubjectList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jSubjectList.setLayoutOrientation(JList.VERTICAL);
        jSubjectList.setVisibleRowCount(-1);
        JScrollPane leftListScroller = new JScrollPane(jSubjectList);
        leftListScroller.setPreferredSize(new Dimension(150, 80));
        JButton addSubjectBtn = new JButton("Add Subject");
        subjectsPanel.add(addSubjectBtn, BorderLayout.SOUTH);

        addSubjectBtn.addActionListener(e -> {
            JTextField xField = new JTextField(5);
            JTextField yField = new JTextField(20);

            JPanel myPanel = new JPanel();
            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
            myPanel.add(new JLabel("Subject Name"));
            myPanel.add(xField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Subject Description"));
            myPanel.add(yField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "New Subject", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                if (Subject.create(xField.getText(), yField.getText())) {
                    jSubjectList.setModel(Subject.getSubjects());
                    subjectsPanel.invalidate();
                    subjectsPanel.repaint();
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR BOYZ!");
                }
            }
        });



        jTopicList = new JList(new DefaultListModel<Topic>());
        jTopicList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTopicList.setLayoutOrientation(JList.VERTICAL);
        jTopicList.setVisibleRowCount(-1);
        jTopicList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    Topic topic = (Topic) ((JList) e.getSource())
                            .getSelectedValue();
                    jPostList.setModel(Post.getPostByTopicId(topic.getTopicId()));
                    current_topic = topic.getTopicId();
                    postPanel.invalidate();
                    postPanel.repaint();
                }
            }
        });
        JScrollPane middleListScroller = new JScrollPane(jTopicList);
        middleListScroller.setPreferredSize(new Dimension(375, 80));
        JButton addTopicBtn = new JButton("Add Topic");
        topicsPanel.add(addTopicBtn, BorderLayout.SOUTH);

        addTopicBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField xField = new JTextField(5);
                JTextField yField = new JTextField(20);

                JPanel myPanel = new JPanel();
                myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
                myPanel.add(new JLabel("Topic Name"));
                myPanel.add(xField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("Topic Description"));
                myPanel.add(yField);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "New Topic", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    if (Topic.create(current_subject, xField.getText(), yField.getText())) {
                        jTopicList.setModel(Topic.getTopicsBySubjectId(current_subject));
                        topicsPanel.invalidate();
                        topicsPanel.repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "ERROR BOYZ!");
                    }
                }
            }
        });



        jPostList = new JList(new DefaultListModel<Post>());
        jPostList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jPostList.setLayoutOrientation(JList.VERTICAL);
        jPostList.setVisibleRowCount(-1);
        jPostList.setCellRenderer(new PostRenderer());
        JScrollPane rightListScroller = new JScrollPane(jPostList);
        JButton addPostBtn = new JButton("Add Reply");
        postPanel.add(addPostBtn, BorderLayout.SOUTH);

        addPostBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField xField = new JTextField(5);
                JTextField yField = new JTextField(20);

                JPanel myPanel = new JPanel();
                myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
                myPanel.add(new JLabel("Topic Name"));
                myPanel.add(xField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("Topic Description"));
                myPanel.add(yField);

                int result = JOptionPane.showConfirmDialog(null, myPanel,
                        "New Topic", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    if (Post.create(current_topic, xField.getText(), yField.getText())) {
                        jPostList.setModel(Post.getPostByTopicId(current_topic));
                        postPanel.invalidate();
                        postPanel.repaint();
                    }else {
                        JOptionPane.showMessageDialog(null, "ERROR BOYZ!");
                    }
                }
            }
        });

        jSubjectList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {

                    Subject subject = (Subject) ((JList) e.getSource())
                            .getSelectedValue();
                    current_subject = subject.getSubjectId();
                    DefaultListModel listModel = (DefaultListModel) jPostList.getModel();
                    listModel.removeAllElements();
                    jTopicList.setModel(Topic.getTopicsBySubjectId(subject.getSubjectId()));
                    topicsPanel.invalidate();
                    topicsPanel.repaint();
                }
            }
        });
        subjectsPanel.add(leftListScroller);
        topicsPanel.add(middleListScroller);
        postPanel.add(rightListScroller);
        innerSplitPane.setLeftComponent(subjectsPanel);
        innerSplitPane.setRightComponent(topicsPanel);
        outerSplitPane.setLeftComponent(innerSplitPane);
        outerSplitPane.setRightComponent(postPanel);
        add(outerSplitPane, BorderLayout.CENTER);

    }
}
