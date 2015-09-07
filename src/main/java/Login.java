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
    JButton btnLogin;
    JPasswordField txtPass;
    JButton btnReg;

    public Login() {
        initComponents();
    }

    private void initComponents() {
        setTitle("MMU BOARD");
        setLayout(null);
        setSize(490, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("WELCOME TO MMU BOARD");
        l1.setFont(new Font("Courier New", Font.BOLD, 20));

        l2 = new JLabel("Enter Username:");
        l3 = new JLabel("Enter Password:");
        txtUser = new JTextField();
        txtPass = new JPasswordField();
        btnLogin = new JButton("Login");
        btnReg = new JButton("Register");

        l1.setBounds(120, 40, 400, 30);
        l2.setBounds(80, 80, 200, 30);
        l3.setBounds(80, 120, 200, 30);
        txtUser.setBounds(200, 80, 200, 30);
        txtPass.setBounds(200, 120, 200, 30);
        btnLogin.setBounds(250, 170, 100, 30);
        btnReg.setBounds(150, 170, 100, 30);

        add(l1);
        add(l2);
        add(txtUser);
        add(l3);
        add(txtPass);
        add(btnLogin);
        add(btnReg);
        btnLogin.addActionListener(this);
        btnReg.addActionListener(this);
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        Login login = new Login();
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JFrame.setDefaultLookAndFeelDecorated(true);
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            User users = new User();
            if (txtUser.getText().length() == 0)  // Checking for empty field
                JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
            else if (txtPass.getPassword().length == 0)  // Checking for empty field
                JOptionPane.showMessageDialog(null, "Empty fields detected ! Please fill up all fields");
            else {
                String user = txtUser.getText();   // Collecting the input
                char[] pass = txtPass.getPassword(); // Collecting the input
                String pwd = String.copyValueOf(pass);  // converting from array to string
                if ("student".equals(users.validate_login(user, pwd))) {
                    //JOptionPane.showMessageDialog(null, "Correct Login Credentials");
                    LecturerDash lecturerDash = new LecturerDash();
                    lecturerDash.setSize(900, 500);
                    lecturerDash.setLocationRelativeTo(null);
                    lecturerDash.setVisible(true);
                    this.dispose();//to close the current jfram
                } else if ("lecturer".equals(users.validate_login(user, pwd))) {
                    new LecturerDash().setVisible(true);
                    this.dispose();//to close the current jfram
                } else
                    JOptionPane.showMessageDialog(null, "Incorrect Login Credentials");
            }
        }
        if (e.getSource() == btnReg){

        }
    }
}
