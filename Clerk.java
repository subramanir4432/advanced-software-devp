package cam.user;

import cam.Cam;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static cam.utils.Constant.*;

public class Clerk extends JFrame {
    private static Clerk clerkFrame;
    private JPanel contentPane;
    private JTextField userNameField;
    private JPasswordField passwordField;
    /**
     * Create the clerkFrame.
     */
    public Clerk() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(120, 120, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // User Name Box
        userNameField = new JTextField();
        userNameField.setColumns(10);
        //
        passwordField = new JPasswordField();
        //
        JLabel clerkLoginLabel = new JLabel(CLERK_LOGIN);
        clerkLoginLabel.setForeground(Color.WHITE);
        clerkLoginLabel.setFont(new Font(FONT, Font.PLAIN, 18));
        //
        JLabel enterNameLabel = new JLabel(ENTER_NAME);
        enterNameLabel.setForeground(Color.WHITE);
        JLabel enterPasswordLabel = new JLabel(ENTER_PASS);
        enterPasswordLabel.setForeground(Color.WHITE);

        // Back
        JButton backButton = new JButton(BACK);
        backButton.addActionListener(e -> {
            Cam.main(new String[]{});
            clerkFrame.dispose();
        });
        backButton.setForeground(Color.RED);
        //
        JButton loginButton = new JButton(LOGIN);
        loginButton.addActionListener(e -> {
            String name=userNameField.getText();
            String password=String.valueOf(passwordField.getPassword());
            if(ClerkDAO.validate(name, password)){
                ClerkAfterLogin.main(new String[]{});
                clerkFrame.dispose();
            }else{
                JOptionPane.showMessageDialog(Clerk.this, LOGIN_INVALID,LOGIN_ERROR, JOptionPane.ERROR_MESSAGE);
                userNameField.setText("");
                passwordField.setText("");
            }
        });
        loginButton.setForeground(Color.RED);
        
        GroupLayout groupLayout = new GroupLayout(contentPane);
        // Horizontal Group
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(124)
                            .addComponent(clerkLoginLabel))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(19)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(enterNameLabel)
                                .addComponent(enterPasswordLabel))
                            .addGap(47)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(passwordField)
                                .addComponent(userNameField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
                    .addContainerGap(107, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(187, Short.MAX_VALUE)
                    .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                    .addGap(151))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(187, Short.MAX_VALUE)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                    .addGap(151))
        );

        // Vertical Group
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(clerkLoginLabel)
                    .addGap(26)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(enterNameLabel)
                        .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(enterPasswordLabel)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE))
        );
        // Add Layout to ContentPane
        contentPane.setLayout(groupLayout);
    }
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                clerkFrame = new Clerk();
                clerkFrame.getContentPane().setBackground(Color.BLUE);
                clerkFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
