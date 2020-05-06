package cam.user;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static cam.utils.Constant.*;

public class ClerkAdd extends JFrame {
    static ClerkAdd clerkAddFrame;
    private JPanel contentPane;
    private JTextField nameField, emailField, addressField, cityField, contactField;
    private JPasswordField passwordField;
    /**
     * Create the clerkAddFrame.
     */
    public ClerkAdd() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // All Fields
        nameField = new JTextField();
        nameField.setColumns(10);
        emailField = new JTextField();
        emailField.setColumns(10);
        addressField = new JTextField();
        addressField.setColumns(10);
        cityField = new JTextField();
        cityField.setColumns(10);
        contactField = new JTextField();
        contactField.setColumns(10);
        passwordField = new JPasswordField();
        // All Labels
        JLabel addClerkLabel = new JLabel(ADD_CLERK);
        addClerkLabel.setForeground(Color.WHITE);
        addClerkLabel.setFont(new Font(FONT, Font.PLAIN, 22));
        JLabel nameLabel = new JLabel(NAME);
        nameLabel.setForeground(Color.WHITE);
        JLabel passwordLabel = new JLabel(PASS);
        passwordLabel.setForeground(Color.WHITE);
        JLabel emailLabel = new JLabel(EMAIL);
        emailLabel.setForeground(Color.WHITE);
        JLabel addressLabel = new JLabel(ADDRESS);
        addressLabel.setForeground(Color.WHITE);
        JLabel cityLabel = new JLabel(CITY);
        cityLabel.setForeground(Color.WHITE);
        JLabel contactNoLabel = new JLabel(CONTACT_NO);
        contactNoLabel.setForeground(Color.WHITE);
        // Back Button
        JButton backButton = new JButton(BACK);
        backButton.addActionListener(e -> {
            ManagerAfterLogin.main(new String[]{});
            clerkAddFrame.dispose();
        });
        backButton.setForeground(Color.RED);
        // Add buttons
        JButton addClerkButton = new JButton(ADD_CLERK);
        addClerkButton.addActionListener(e -> {
            String name = nameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String email = emailField.getText();
            String address = addressField.getText();
            String city = cityField.getText();
            String contact = contactField.getText();
            int i = ClerkDAO.save(name, password, email, address, city, contact);
            if (i > 0) {
                JOptionPane.showMessageDialog(ClerkAdd.this, CLERK_SUCCESS);
                ManagerAfterLogin.main(new String[]{});
                clerkAddFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(ClerkAdd.this, UNABLE_SAVE);
            }
        });
        addClerkButton.setForeground(Color.RED);
        // Group layout
        GroupLayout groupLayout = new GroupLayout(contentPane);
        // Horizontal Group
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(20)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(passwordLabel)
                        .addComponent(nameLabel)
                        .addComponent(emailLabel)
                        .addComponent(addressLabel)
                        .addComponent(cityLabel)
                        .addComponent(contactNoLabel))
                    .addGap(58)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(contactField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addComponent(cityField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addComponent(addressField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addComponent(emailField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addComponent(nameField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addComponent(passwordField))
                    .addContainerGap(107, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(151, Short.MAX_VALUE)
                    .addComponent(addClerkLabel)
                    .addGap(144))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(160, Short.MAX_VALUE)
                    .addComponent(addClerkButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                    .addGap(133))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(200, Short.MAX_VALUE)
                    .addComponent(backButton)
                    .addGap(169))
        );
        // Vertical Group
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(addClerkLabel)
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(nameLabel)
                            .addGap(18)
                            .addComponent(passwordLabel))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(emailLabel)
                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(addressLabel)
                        .addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(cityLabel)
                        .addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(contactNoLabel)
                        .addComponent(contactField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addComponent(addClerkButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                    .addComponent(backButton)
                    .addGap(19))
        );
        // Set groupLayout to Pane
        contentPane.setLayout(groupLayout);
    }
    /**
     * Launch the clerk app.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                clerkAddFrame = new ClerkAdd();
                clerkAddFrame.getContentPane().setBackground(Color.BLUE);
                clerkAddFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
