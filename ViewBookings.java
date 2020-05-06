package cam.booking;

import cam.utils.ConnectionUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import static cam.utils.Constant.ROOM_CURRENT_SELECT;

public class ViewBookings extends JFrame {

    private JPanel contentPane;
    private JTable table;
    /**
     * Create the ViewBookingsFrame.
     */
    public ViewBookings() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(120, 120, 950, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        String data[][] = null;
        String column[] = null;
        try {
            Connection con = ConnectionUtils.getConnection();
            PreparedStatement ps = null;
            ps = con.prepareStatement(ROOM_CURRENT_SELECT, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = rsmd.getColumnName(i);
            }
            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();
            data = new String[rows][cols];
            int count = 0;
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    data[count][i - 1] = rs.getString(i);
                }
                count++;
            }
            con.close();
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
                ViewBookings viewBookingsFrame = new ViewBookings();
                viewBookingsFrame.getContentPane().setBackground(Color.BLUE);
                viewBookingsFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
