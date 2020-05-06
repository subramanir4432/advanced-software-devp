package cam.booking;

import cam.user.ClerkAfterLogin;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static cam.utils.Constant.*;

public class CancelBooking extends JFrame {
    private static CancelBooking cancelBookingFrame;
    private JPanel contentPane;
    private JTextField bookingIdField;
    /**
     * Create the cancelBookingFrame.
     */
    public CancelBooking() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 110, 516, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // 
        bookingIdField = new JTextField();
        bookingIdField.setColumns(10);
        //
        JLabel cancelBookingLabel = new JLabel(CANCEL_BOOKING);
        cancelBookingLabel.setForeground(Color.WHITE);
        cancelBookingLabel.setFont(new Font(FONT, Font.PLAIN, 18));

        JLabel bookingIdLabel = new JLabel(BOOKING_ID);
        bookingIdLabel.setForeground(Color.WHITE);
        // 
        JButton backButton = new JButton(BACK);
        backButton.addActionListener(e -> {
            ClerkAfterLogin.main(new String[]{});
            cancelBookingFrame.dispose();
        });
        backButton.setForeground(Color.RED);
        //
        JButton cancelBookingButton = new JButton(CANCEL_BOOKING);
        cancelBookingButton.addActionListener(e -> {
            String bookingId = bookingIdField.getText();
            int i = BookingDAO.delete(bookingId);
            if (i > 0) {
                JOptionPane.showMessageDialog(CancelBooking.this, BOOKING_CANCEL_SUCCESS);
                ClerkAfterLogin.main(new String[]{});
                cancelBookingFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(CancelBooking.this, SORRY_UNABLE_TO_CANCEL);
            }
        });
        cancelBookingButton.setForeground(Color.RED);
        // 
        JLabel noteLabel = new JLabel(BEFORE_CANCEL);
        noteLabel.setForeground(Color.RED);
        noteLabel.setFont(new Font(FONT, Font.PLAIN, 13));
        //
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(36)
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(bookingIdLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(56)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(bookingIdField, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(139, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(210, Short.MAX_VALUE)
                    .addComponent(cancelBookingButton)
                    .addGap(176))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(205, Short.MAX_VALUE)
                    .addComponent(cancelBookingLabel)
                    .addGap(187))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(19)
                    .addComponent(noteLabel)
                    .addContainerGap(294, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(355, Short.MAX_VALUE)
                    .addComponent(backButton)
                    .addGap(46))
        );
        // Vertical Group
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cancelBookingLabel)
                    .addGap(32)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookingIdLabel)
                        .addComponent(bookingIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(34)
                    .addComponent(cancelBookingButton)
                    .addGap(23)
                    .addComponent(backButton)
                    .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addComponent(noteLabel)
                    .addGap(72)
                    .addComponent(backButton)
                    .addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                    .addComponent(noteLabel)
                    .addGap(72))
        );
        // Set groupLayout to pane
        contentPane.setLayout(groupLayout);
    }
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                cancelBookingFrame = new CancelBooking();
                cancelBookingFrame.getContentPane().setBackground(Color.BLUE);
                cancelBookingFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
