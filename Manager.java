package cam.user;

import cam.Cam;
import cam.utils.Constant;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static cam.utils.Constant.*;

public class Manager extends JFrame {
    private static Manager managerFrame;
    private JPanel contentPane;
    private JTextField userNameField;
    private JPasswordField passwordField;
    /**
     * Create the managerFrame.
     */
    public Manager() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // All fields
        userNameField = new JTextField();
        userNameField.setColumns(10);
        passwordField = new JPasswordField();
        // All Labels
        JLabel managerLoginLabel = new JLabel(MANAGER_LOGIN);
        managerLoginLabel.setForeground(Color.WHITE);
        managerLoginLabel.setFont(new Font(FONT, Font.PLAIN, 18));
        JLabel enterNameField = new JLabel(ENTER_NAME);
        enterNameField.setForeground(Color.WHITE);
        JLabel enterPasswordField = new JLabel(ENTER_PASS);
        enterPasswordField.setForeground(Color.WHITE);
        // Back Button
        JButton backButton = new JButton(BACK);
        backButton.addActionListener(e -> {
            Cam.main(new String[]{});
            managerFrame.dispose();
        });
        backButton.setForeground(Color.RED);

        JButton loginButton = new JButton(LOGIN);
        loginButton.addActionListener(e -> {
            String name=userNameField.getText();
            String password=String.valueOf(passwordField.getPassword());
            if(name.equals(Constant.USER_NAME)&&password.equals(Constant.PASSWORD)){
                ManagerAfterLogin.main(new String[]{});
                managerFrame.dispose();
            }else{
                JOptionPane.showMessageDialog(Manager.this, LOGIN_INVALID,LOGIN_ERROR, JOptionPane.ERROR_MESSAGE);
                userNameField.setText("");
                passwordField.setText("");
            }
        });
        loginButton.setForeground(Color.RED);
        // Group Layout
        GroupLayout groupLayout = new GroupLayout(contentPane);
        // Horizontal Group
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(124)
                            .addComponent(managerLoginLabel))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(19)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(enterNameField)
                                .addComponent(enterPasswordField))
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
                    .addComponent(managerLoginLabel)
                    .addGap(26)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(enterNameField)
                        .addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(enterPasswordField)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE))
        );
        // Add groupLayout to Pane
        contentPane.setLayout(groupLayout);
    }
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                managerFrame = new Manager();
                managerFrame.getContentPane().setBackground(Color.BLUE);
                managerFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
