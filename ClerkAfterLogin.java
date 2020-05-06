package cam.user;


import cam.Cam;
import cam.booking.BookingRoom;
import cam.booking.CancelBooking;
import cam.booking.ViewBookings;
import cam.booking.ViewHistoryBookings;
import cam.room.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static cam.utils.Constant.*;

public class ClerkAfterLogin extends JFrame {
    private static ClerkAfterLogin clerkAfterLoginFame;
    private JPanel contentPane;
    /**
     * Create the clerkAfterLoginFame.
     */
    public ClerkAfterLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(150, 150, 450, 473);
        contentPane = new JPanel();
        contentPane.setForeground(Color.GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        //
        JLabel lblClerkSection = new JLabel(TITLE);
        lblClerkSection.setFont(new Font(FONT, Font.PLAIN, 22));
        lblClerkSection.setForeground(Color.WHITE);
        //
        JButton viewAllRoomsButton = new JButton(VIEW_ALL_ROOMS);
        viewAllRoomsButton.addActionListener(arg0 -> RoomView.main(new String[]{}));
        viewAllRoomsButton.setFont(new Font(FONT, Font.PLAIN, 13));
        viewAllRoomsButton.setForeground(Color.RED);
        //
        JButton bookRoomButton = new JButton(BOOK_ROME);
        bookRoomButton.addActionListener(e -> {
            BookingRoom.main(new String[]{});
            clerkAfterLoginFame.dispose();
        });
        bookRoomButton.setFont(new Font(FONT, Font.PLAIN, 13));
        bookRoomButton.setForeground(Color.RED);
        //
        JButton viewBookedRoomsButton = new JButton(VIEW_BOOKINGS);
        viewBookedRoomsButton.addActionListener(e -> ViewBookings.main(new String[]{}));
        viewBookedRoomsButton.setFont(new Font(FONT, Font.PLAIN, 13));
        viewBookedRoomsButton.setForeground(Color.RED);
        //
        JButton viewPastBookingRoomsButton = new JButton(VIEW_HISTORY_BOOKINGS);
        viewPastBookingRoomsButton.addActionListener(e -> ViewHistoryBookings.main(new String[]{}));
        viewPastBookingRoomsButton.setFont(new Font(FONT, Font.PLAIN, 13));
        viewPastBookingRoomsButton.setForeground(Color.RED);
        //
        JButton cancelBookingButton = new JButton(CANCEL_BOOKINGS);
        cancelBookingButton.addActionListener(e -> {
            CancelBooking.main(new String[]{});
            clerkAfterLoginFame.dispose();
        });
        cancelBookingButton.setFont(new Font(FONT, Font.PLAIN, 13));
        cancelBookingButton.setForeground(Color.RED);
        //
        JButton logoutButton = new JButton(LOGOUT);
        logoutButton.addActionListener(e -> {
            Cam.main(new String[]{});
            clerkAfterLoginFame.dispose();
        });
        logoutButton.setFont(new Font(FONT, Font.PLAIN, 13));
        logoutButton.setForeground(Color.RED);
        //
        GroupLayout groupLayout = new GroupLayout(contentPane);
        // Horizontal Group
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(lblClerkSection)
                    .addGap(54))
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(132)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelBookingButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewBookedRoomsButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewPastBookingRoomsButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addComponent(bookRoomButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
                        .addComponent(viewAllRoomsButton, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(101, Short.MAX_VALUE))
        );
        // Vertical Group
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblClerkSection)
                    .addGap(18)
                    .addComponent(viewAllRoomsButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(bookRoomButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(viewBookedRoomsButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(viewPastBookingRoomsButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(cancelBookingButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE))
        );
        // Add groupLayout to contentPane
        contentPane.setLayout(groupLayout);
    }
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                clerkAfterLoginFame = new ClerkAfterLogin();
                clerkAfterLoginFame.getContentPane().setBackground(Color.BLUE);
                clerkAfterLoginFame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
