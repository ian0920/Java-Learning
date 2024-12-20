import java.sql.*;

public class TestStatement {

    public static void main(String[] args) {

        String userName = "root";
        String password = "Aa12345678";
        String URL = "jdbc:mysql://localhost:3306/jdbcsample";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {

            //載入驅動
            Class.forName("com.mysql.cj.jdbc.Driver");

            //建立連線
            con = DriverManager.getConnection(URL, userName, password);
            stmt = con.createStatement();


            String SQL = "select * from department";

            rs = stmt.executeQuery(SQL);

            System.out.println(rs.next());
            System.out.println(rs.getRow());
            System.out.println(rs.isFirst());
            System.out.println(rs.getRow());

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1));




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if(stmt != null)
                    stmt.close();
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
