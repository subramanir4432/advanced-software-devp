package cam.user;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static cam.utils.Constant.*;

public class ClerkDelete extends JFrame {
    private static ClerkDelete clerkDeleteFrame;
    private JPanel contentPane;
    private JTextField enterIdField;
    /**
     * Create the clerkDeleteFrame.
     */
    public ClerkDelete() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        enterIdField = new JTextField();
        enterIdField.setColumns(10);
        
        JLabel enterIdLabel = new JLabel(ENTER_ID);
        enterIdLabel.setForeground(Color.WHITE);
        JButton backButton = new JButton(BACK);
        backButton.addActionListener(e -> {
            ManagerAfterLogin.main(new String[]{});
            clerkDeleteFrame.dispose();
        });
        backButton.setFont(new Font(FONT, Font.PLAIN, 13));
        backButton.setForeground(Color.RED);
        //
        JButton deleteButton = new JButton(DELETE);
        deleteButton.addActionListener(e -> {
            String sid = enterIdField.getText();
            if (sid == null || sid.trim().equals("")) {
                JOptionPane.showMessageDialog(ClerkDelete.this, ID_NOT_NULL);
            } else {
                if (ClerkDAO.delete(Integer.parseInt(sid)) > 0) {
                    JOptionPane.showMessageDialog(ClerkDelete.this, CLERK_DELETE_SUCCESS);
                    ManagerAfterLogin.main(new String[]{});
                    clerkDeleteFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(ClerkDelete.this, UNABLE_TO_DELETE);
                }
            }
        });
        deleteButton.setFont(new Font(FONT, Font.PLAIN, 13));
        deleteButton.setForeground(Color.RED);
        // Group Layout
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(39)
                    .addComponent(enterIdLabel)
                    .addGap(57)
                    .addComponent(enterIdField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(107, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                    .addContainerGap(175, Short.MAX_VALUE)
                    .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                    .addGap(140))
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                    .addContainerGap(175, Short.MAX_VALUE)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                    .addGap(140))
        );
        // Vertical Group
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(19)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(enterIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(enterIdLabel))
                    .addGap(33)
                    .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addGap(43)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                    .addGap(43))
        );
        // Add Group layout to Pane
        contentPane.setLayout(groupLayout);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                clerkDeleteFrame = new ClerkDelete();
                clerkDeleteFrame.getContentPane().setBackground(Color.BLUE);
                clerkDeleteFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
