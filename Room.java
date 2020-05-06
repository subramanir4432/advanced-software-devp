package cam.room;

import cam.user.ManagerAfterLogin;
import com.github.lgooddatepicker.components.DateTimePicker;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static cam.utils.Constant.*;

public class Room extends JFrame {
    private static Room roomFrame;
    private static String roomType[] = {"Class Room", "Auditorium", "Cafeteria", "Tutorial Theater", "Game Room", "Computer Lab", "Chemistry Lab", "Physics Lab", "CAD-CAM Lab", "Other Lab", "Video Room"};
    private static String availableFor[] = {"Term Time", "Weekends", "Holidays"};

    private JPanel contentPane;
    private JTextField roomIdField, nameField, capacityField;
    private JCheckBox checkBox;
    private JComboBox roomTypeField, availableForComboBox;
    private DateTimePicker startDateTimePicker, endDateTimePicker;

    /**
     * Create the roomFrame.
     */
    public Room() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(165, 165, 600, 554);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        // All components
        roomIdField = new JTextField();
        roomIdField.setColumns(10);
        nameField = new JTextField();
        nameField.setColumns(10);
        capacityField = new JTextField();
        capacityField.setColumns(10);
        startDateTimePicker = new DateTimePicker();
        endDateTimePicker = new DateTimePicker();
        add(startDateTimePicker);
        add(endDateTimePicker);
        roomTypeField = new JComboBox(roomType);
        availableForComboBox = new JComboBox(availableFor);
        checkBox = new JCheckBox();
        checkBox.setBounds(100, 100, 50, 50);
        // All Labels
        JLabel addRoomLabel = new JLabel(ADD_ROOM);
        addRoomLabel.setForeground(Color.WHITE);
        addRoomLabel.setFont(new Font(FONT, Font.PLAIN, 18));
        JLabel roomNoLabel = new JLabel(ROOM_NO);
        roomNoLabel.setForeground(Color.WHITE);
        JLabel nameLabel = new JLabel(NAME);
        nameLabel.setForeground(Color.WHITE);
        JLabel capacityLabel = new JLabel(CAPACITY);
        capacityLabel.setForeground(Color.WHITE);
        JLabel roomTypeLabel = new JLabel(ROOM_TYPE);
        roomTypeLabel.setForeground(Color.WHITE);
        JLabel availableStartDateLabel = new JLabel(AVAILABLE_START_DATE);
        availableStartDateLabel.setForeground(Color.WHITE);
        JLabel availableEndDateLabel = new JLabel(AVAILABLE_END_DATE);
        availableEndDateLabel.setForeground(Color.WHITE);
        JLabel availableForLabel = new JLabel(AVAILABLE_FOR);
        availableForLabel.setForeground(Color.WHITE);
        JLabel availableLabel = new JLabel(IS_AVAILABLE);
        availableLabel.setForeground(Color.WHITE);
        // Buttons
        JButton backButton = new JButton(BACK);
        backButton.addActionListener(e -> {
            ManagerAfterLogin.main(new String[]{});
            roomFrame.dispose();
        });
        backButton.setForeground(Color.RED);
        //
        JButton addRoomButton = new JButton(ADD_ROOM);
        addRoomButton.addActionListener(e -> {
            String roomId = roomIdField.getText();
            String name = nameField.getText();
            String capacity = capacityField.getText();
            String roomType = (String) roomTypeField.getSelectedItem();
            LocalDateTime availableFrom = startDateTimePicker.getDateTimePermissive();
            LocalDateTime availableTill = endDateTimePicker.getDateTimePermissive();
            String availableFor = (String) availableForComboBox.getSelectedItem();
            int i = RoomDAO.save(roomId, name, Integer.parseInt(capacity), roomType, Timestamp.valueOf(availableFrom),
                    Timestamp.valueOf(availableTill), availableFor, checkBox.isSelected());
            if (i > 0) {
                JOptionPane.showMessageDialog(Room.this, ROOM_ADDED);
                ManagerAfterLogin.main(new String[]{});
                roomFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(Room.this, UNABLE_SAVE);
            }
        });
        addRoomButton.setForeground(Color.RED);
        // Group layout
        GroupLayout groupLayout = new GroupLayout(contentPane);
        // Horizontal Group
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(150)
                                .addComponent(addRoomLabel))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(18)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                                .addComponent(nameLabel)
                                .addComponent(roomNoLabel)
                                .addComponent(capacityLabel)
                                .addComponent(roomTypeLabel)
                                .addComponent(availableStartDateLabel)
                                .addComponent(availableEndDateLabel)
                                .addComponent(availableForLabel)
                                .addComponent(availableLabel))
                            .addGap(47)
                            .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(checkBox, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addComponent(availableForComboBox, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addComponent(endDateTimePicker)
                                .addComponent(startDateTimePicker)
                                .addComponent(roomTypeField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addComponent(capacityField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                                .addComponent(roomIdField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(125, Short.MAX_VALUE))
                .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                    .addGap(161)
                    .addComponent(addRoomButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE))
                .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap(359, Short.MAX_VALUE)
                    .addComponent(backButton)
                    .addContainerGap())
        );
        // Vertical Group
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(addRoomLabel)
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(roomNoLabel)
                        .addComponent(roomIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(capacityLabel)
                        .addComponent(capacityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(roomTypeLabel)
                        .addComponent(roomTypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(availableStartDateLabel)
                        .addComponent(startDateTimePicker))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(availableEndDateLabel)
                        .addComponent(endDateTimePicker))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(availableForLabel)
                        .addComponent(availableForComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(availableLabel)
                        .addComponent(checkBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(30)
                    .addComponent(addRoomButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(backButton)
                    .addContainerGap(53, Short.MAX_VALUE))
        );
        // Set groupLayout to Pane
        contentPane.setLayout(groupLayout);
    }
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                roomFrame = new Room();
                roomFrame.getContentPane().setBackground(Color.BLUE);
                roomFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
