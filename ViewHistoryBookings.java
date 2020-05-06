package cam.booking;

import cam.utils.ConnectionUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import static cam.utils.Constant.ROOM_PAST_SELECT;

public class ViewHistoryBookings extends JFrame {

    private JPanel contentPane;
    private JTable table;
    /**
     * Create the frame.
     */
    public ViewHistoryBookings() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(120, 120, 950, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        String data[][] = null;
        String column[] = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ROOM_PAST_SELECT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
        contentPane.add(jScrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewHistoryBookings viewHistoryBookingsFrame = new ViewHistoryBookings();
                viewHistoryBookingsFrame.getContentPane().setBackground(Color.BLUE);
                viewHistoryBookingsFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
