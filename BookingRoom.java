package cam.booking;

import com.github.lgooddatepicker.components.DateTimePicker;
import cam.user.ClerkAfterLogin;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static cam.utils.Constant.*;

public class BookingRoom extends JFrame {
    private static BookingRoom bookingRoomFrame;
    private JPanel contentPane;
    private JTextField bookedByField, guestIdField, guestContactField, bookedForField;
    private JTextArea guestAddressTextArea, reasonTextArea;
    private DateTimePicker bookedFromDateTime, bookedToDateTime;
    private JComboBox roomIdComboBox;
    /**
     * Create the bookingRoomFrame.
     */
    public BookingRoom() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 80, 638, 714);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // all components
        bookedByField = new JTextField();
        bookedByField.setColumns(10);
        guestIdField = new JTextField();
        guestIdField.setColumns(10);
        guestAddressTextArea = new JTextArea(3, 20);
        guestAddressTextArea.setColumns(10);
        guestContactField = new JTextField();
        guestContactField.setColumns(10);
        bookedForField = new JTextField();
        bookedForField.setColumns(10);
        reasonTextArea = new JTextArea(4, 20);
        reasonTextArea.setColumns(10);
        bookedFromDateTime = new DateTimePicker();
        bookedToDateTime = new DateTimePicker();
        add(bookedFromDateTime);
        add(bookedToDateTime);
        // 
        List<String> availableRooms = BookingDAO.getAvilableRooms();
        if (0 == availableRooms.size()) {
            JOptionPane.showMessageDialog(BookingRoom.this, PLS_ADD_ROOMS);
            ClerkAfterLogin.main(new String[]{});
            bookingRoomFrame.dispose();
        }
        roomIdComboBox = new JComboBox(availableRooms.toArray());
        // All Labels
        JLabel bookRoomLabel = new JLabel(BOOK_ROME);
        bookRoomLabel.setFont(new Font(FONT, Font.PLAIN, 16));
        bookRoomLabel.setForeground(Color.WHITE);
        JLabel roomNoLabel = new JLabel(ROOM_NO);
        roomNoLabel.setForeground(Color.WHITE);
        JLabel bookedByLabel = new JLabel(BOOKED_BY);
        bookedByLabel.setForeground(Color.WHITE);
        JLabel bookedByLabelGuestId = new JLabel(BOOKED_GUEST_ID);
        bookedByLabelGuestId.setForeground(Color.WHITE);
        JLabel bookedGuestAddressLabel = new JLabel(BOOKED_GUEST_ADDRESS);
        bookedGuestAddressLabel.setForeground(Color.WHITE);
        JLabel bookedGuestContactLabel = new JLabel(BOOKED_GUEST_CONTACT);
        bookedGuestContactLabel.setForeground(Color.WHITE);
        JLabel bookedForLabel = new JLabel(BOOKED_FOR);
        bookedForLabel.setForeground(Color.WHITE);
        JLabel bookedFromLabel = new JLabel(FROM);
        bookedFromLabel.setForeground(Color.WHITE);
        JLabel bookedToLabel = new JLabel(TO);
        bookedToLabel.setForeground(Color.WHITE);
        JLabel bookedReasonLabel = new JLabel(REASON);
        bookedReasonLabel.setForeground(Color.WHITE);
        // Back
        JButton backButton = new JButton(BACK);
        backButton.addActionListener(e -> {
            ClerkAfterLogin.main(new String[]{});
            bookingRoomFrame.dispose();
        });
        backButton.setForeground(Color.RED);
        // Button and Action
        JButton bookRoomButton = new JButton(BOOK_ROME);
        bookRoomButton.addActionListener(e -> {
            String roomId = (String) roomIdComboBox.getSelectedItem();
            String bookedBy = bookedByField.getText();
            String guestId = guestIdField.getText();
            String guestAddress = guestAddressTextArea.getText();
            String guestContact = guestContactField.getText();
            String bookedFor = bookedForField.getText();
            LocalDateTime bookedFrom = bookedFromDateTime.getDateTimePermissive();
            LocalDateTime bookedTo = bookedToDateTime.getDateTimePermissive();
            String reason = reasonTextArea.getText();
            int i = BookingDAO.save(roomId, bookedBy, guestId, guestAddress, guestContact, bookedFor, Timestamp.valueOf(bookedFrom), Timestamp.valueOf(bookedTo), reason);
            if (i > 0) {
                JOptionPane.showMessageDialog(BookingRoom.this, ROOM_SUCCESS);
                ClerkAfterLogin.main(new String[]{});
                bookingRoomFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(BookingRoom.this, UNABLE_RO_BOOK_ROOM);
            }//end of save if-else
        });
        bookRoomButton.setForeground(Color.RED);
        //
        JLabel noteLabel = new JLabel(CHECK_GUEST);
        noteLabel.setFont(new Font(FONT, Font.PLAIN, 13));
        noteLabel.setForeground(Color.RED);
        GroupLayout groupLayout = new GroupLayout(contentPane);
        // Horizontal Group
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(8, Short.MAX_VALUE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(roomNoLabel)
                                .addComponent(bookedByLabel)
                                .addComponent(bookedByLabelGuestId)
                                .addComponent(bookedGuestAddressLabel)
                                .addComponent(bookedGuestContactLabel)
                                .addComponent(bookedForLabel)
                                .addComponent(bookedFromLabel)
                                .addComponent(bookedToLabel)
                                .addComponent(bookedReasonLabel))
                            .addGap(8)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(roomIdComboBox, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bookedByField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(guestIdField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(guestAddressTextArea, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(guestContactField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bookedForField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                .addComponent(bookedFromDateTime)
                                .addComponent(bookedToDateTime)
                                .addComponent(reasonTextArea, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                            .addGap(45))
                        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
                            .addGap(15)
                            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                .addComponent(noteLabel)
                                .addGroup(groupLayout.createSequentialGroup()
                                    .addComponent(bookRoomButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                    .addGap(47)
                                    .addComponent(backButton)))
                            .addGap(100))))
                .addGroup(groupLayout.createSequentialGroup()
                        .addGap(146)
                        .addComponent(bookRoomLabel)
                        .addContainerGap(235, Short.MAX_VALUE))
        );
        // Vertical Group
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(34)
                    .addComponent(bookRoomLabel)
                    .addGap(40)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(roomNoLabel)
                        .addComponent(roomIdComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookedByLabel)
                        .addComponent(bookedByField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookedByLabelGuestId)
                        .addComponent(guestIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookedGuestAddressLabel)
                        .addComponent(guestAddressTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookedGuestContactLabel)
                        .addComponent(guestContactField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookedForLabel)
                        .addComponent(bookedForField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(25)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookedFromLabel)
                        .addComponent(bookedFromDateTime))
                    .addGap(25)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookedToLabel)
                        .addComponent(bookedToDateTime))
                    .addGap(25)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookedReasonLabel)
                        .addComponent(reasonTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(bookRoomButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                        .addComponent(backButton))
                    .addGap(18)
                    .addComponent(noteLabel)
                    .addGap(25))
        );
        // Add  groupLayout to contentPane
        contentPane.setLayout(groupLayout);
    }
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                bookingRoomFrame = new BookingRoom();
                bookingRoomFrame.getContentPane().setBackground(Color.BLUE);
                bookingRoomFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
