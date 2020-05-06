package cam;

import cam.user.Manager;
import cam.user.Clerk;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static cam.utils.Constant.*;

public class Cam extends JFrame {
    static Cam camFrame;
    private JPanel contentPane;
    /**
     * Create the frame.
     */
    public Cam() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //
        JLabel camManagementLabel = new JLabel(TITLE);
        camManagementLabel.setFont(new Font(FONT, Font.PLAIN, 18));
        camManagementLabel.setForeground(Color.WHITE);
        //
        JButton adminLoginLabel = new JButton(MANAGER_LOGIN);
        adminLoginLabel.addActionListener(e -> {
            Manager.main(new String[]{});
            camFrame.dispose();
        });
        adminLoginLabel.setFont(new Font(FONT, Font.PLAIN, 15));
        adminLoginLabel.setForeground(Color.RED);

        JButton clerkLoginLabel = new JButton(CLERK_LOGIN);
        clerkLoginLabel.addActionListener(arg0 -> Clerk.main(new String[]{}));
        clerkLoginLabel.setFont(new Font(FONT, Font.PLAIN, 15));
        clerkLoginLabel.setForeground(Color.RED);
        // Group Layout Design
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(64)
                            .addComponent(camManagementLabel))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(140)
                            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                            .addComponent(clerkLoginLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adminLoginLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
                    .addContainerGap(95, Short.MAX_VALUE))
        );
        // Vertical Group
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(camManagementLabel)
                    .addGap(32)
                    .addComponent(adminLoginLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(clerkLoginLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE))
        );
        // Set groupLayout to Pane
        contentPane.setLayout(groupLayout);
    }
    /**
     * Launch the CAM App.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                camFrame= new Cam();
                camFrame.getContentPane().setBackground(Color.BLUE);
                camFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println("CAM Application is Launched!!");
    }
}
