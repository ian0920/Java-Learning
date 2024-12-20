import java.sql.*;

public class TestPreparedStatement {

    public static void main(String[] args) {

        String userName = "root";
        String password = "Aa12345678";
        String URL = "jdbc:mysql://localhost:3306/jdbcsample";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            //載入驅動
            Class.forName("com.mysql.cj.jdbc.Driver");

            //建立連線
            String SQL = "update department set dname = ?, loc = ? where deptno = ?";
            con = DriverManager.getConnection(URL, userName, password);
            pstmt = con.prepareStatement(SQL);

            pstmt.setString(1, "人事部2");
            pstmt.setString(2, "澎湖");
            pstmt.setInt(3, 50);
            pstmt.executeUpdate();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            e.getNextException();
        } finally {

            try {
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(con!= null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

    }
}
