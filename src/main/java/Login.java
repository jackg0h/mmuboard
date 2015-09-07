import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jack on 9/7/15.
 */
public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField txtUser;
    JButton btn1;
    JPasswordField txtPass;

    public Login() {
        initComponents();
    }

    private void initComponents() {
        setTitle("MMU BOARD");
        setVisible(true);
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("WELCOME TO MMU BOARD");
        //l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Enter Username:");
        l3 = new JLabel("Enter Password:");
        txtUser = new JTextField();
        txtPass = new JPasswordField();
        btn1 = new JButton("Submit");

        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        txtUser.setBounds(200, 70, 200, 30);
        txtPass.setBounds(200, 110, 200, 30);
        btn1.setBounds(150, 160, 100, 30);

        add(l1);
        add(l2);
        add(txtUser);
        add(l3);
        add(txtPass);
        add(btn1);
        btn1.addActionListener(this);
    }

    public static void main(String args[]) {
        Login login = new Login();
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setSize(900,500);
        JFrame.setDefaultLookAndFeelDecorated(true);
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        User users= new User();
        if(txtUser.getText().length()==0)  // Checking for empty field
            JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
        else if(txtPass.getPassword().length==0)  // Checking for empty field
            JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
        else{
            String user = txtUser.getText();   // Collecting the input
            char[] pass = txtPass.getPassword(); // Collecting the input
            String pwd = String.copyValueOf(pass);  // converting from array to string
            if("student".equals(users.validate_login(user,pwd)) ){
                //JOptionPane.showMessageDialog(null, "Correct Login Credentials");
                LecturerDash lecturerDash = new LecturerDash();
                lecturerDash.setVisible(true);
                lecturerDash.setSize(900, 500);
                this.dispose();//to close the current jfram
            }
            else if("lecturer".equals(users.validate_login(user,pwd))){
                new LecturerDash().setVisible(true);
                this.dispose();//to close the current jfram
            }
            else
                JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");
        }
    }
}
