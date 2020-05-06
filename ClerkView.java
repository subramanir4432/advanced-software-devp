package cam.user;

import cam.utils.ConnectionUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import static cam.utils.Constant.USER_SELECT;

public class ClerkView extends JFrame {

    private JPanel contentPane;
    private JTable table;
    /**
     * Create the frame.
     */
    public ClerkView() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(110, 130, 1000, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        String data[][] = null;
        String column[] = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(USER_SELECT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int cols = resultSetMetaData.getColumnCount();
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = resultSetMetaData.getColumnName(i);
            }
            resultSet.last();
            int rows = resultSet.getRow();
            resultSet.beforeFirst();
            data = new String[rows][cols];
            int count = 0;
            while (resultSet.next()) {
                for (int i = 1; i <= cols; i++) {
                    data[count][i - 1] = resultSet.getString(i);
                }
                count++;
            }
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        table = new JTable(data, column);
        table.setForeground(Color.WHITE);
        table.setBackground(Color.BLUE);
        table.getTableHeader().setBackground(Color.BLUE);
        table.getTableHeader().setForeground(Color.WHITE);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setForeground(Color.RED);
        contentPane.add(jScrollPane, BorderLayout.CENTER);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ClerkView clerkViewFrame = new ClerkView();
                clerkViewFrame.getContentPane().setBackground(Color.BLUE);
                clerkViewFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
