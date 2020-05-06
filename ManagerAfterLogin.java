package cam.user;

import cam.Cam;
import cam.room.Room;
import cam.room.RoomView;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static cam.utils.Constant.*;

public class ManagerAfterLogin extends JFrame {
	private static ManagerAfterLogin managerAfterLoginFrame;
	private JPanel contentPane;
	/**
	 * Create the managerAfterLoginFrame.
	 */
	public ManagerAfterLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel managerSectionLabel = new JLabel(MANAGER_SECTION);
		managerSectionLabel.setFont(new Font(FONT, Font.PLAIN, 22));
		managerSectionLabel.setForeground(Color.GRAY);
		managerSectionLabel.setForeground(Color.WHITE);
		//
		JButton addClerkButton = new JButton(ADD_CLERK);
		addClerkButton.setFont(new Font(FONT, Font.PLAIN, 15));
		addClerkButton.addActionListener(e -> {
			ClerkAdd.main(new String[]{});
			managerAfterLoginFrame.dispose();
		});
		addClerkButton.setForeground(Color.RED);
		//
		JButton viewClerkButton = new JButton(VIEW_CLERK);
		viewClerkButton.addActionListener(arg0 -> ClerkView.main(new String[]{}));
		viewClerkButton.setFont(new Font(FONT, Font.PLAIN, 15));
		viewClerkButton.setForeground(Color.RED);
		//
		JButton deleteClerkButton = new JButton(DELETE_CLERK);
		deleteClerkButton.addActionListener(e -> {
			ClerkDelete.main(new String[]{});
			managerAfterLoginFrame.dispose();
		});
		deleteClerkButton.setFont(new Font(FONT, Font.PLAIN, 15));
		deleteClerkButton.setForeground(Color.RED);
		//
		JButton addRoomButton = new JButton(ADD_ROOM);
		addRoomButton.addActionListener(e -> {
			Room.main(new String[]{});
			managerAfterLoginFrame.dispose();
		});
		addRoomButton.setFont(new Font(FONT, Font.PLAIN, 15));
		addRoomButton.setForeground(Color.RED);
		//
		JButton viewAllRoomsButton = new JButton(VIEW_ALL_ROOMS);
		viewAllRoomsButton.addActionListener(arg0 -> RoomView.main(new String[]{}));
		viewAllRoomsButton.setFont(new Font(FONT, Font.PLAIN, 15));
		viewAllRoomsButton.setForeground(Color.RED);
		//
		JButton logoutButton = new JButton(LOGOUT);
		logoutButton.addActionListener(arg0 -> {
			Cam.main(new String[]{});
			managerAfterLoginFrame.dispose();
		});
		logoutButton.setFont(new Font(FONT, Font.PLAIN, 15));
		logoutButton.setForeground(Color.RED);
		//
		GroupLayout groupLayout = new GroupLayout(contentPane);
		// Horizontal Group
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(150, Short.MAX_VALUE)
					.addComponent(managerSectionLabel)
					.addGap(123))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(134)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteClerkButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewClerkButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(addClerkButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(addRoomButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(viewAllRoomsButton, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(109, Short.MAX_VALUE))
		);
		// Vertical Group
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(managerSectionLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(addClerkButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(viewClerkButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(deleteClerkButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(addRoomButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(viewAllRoomsButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(groupLayout);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				managerAfterLoginFrame = new ManagerAfterLogin();
				managerAfterLoginFrame.getContentPane().setBackground(Color.BLUE);
				managerAfterLoginFrame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
