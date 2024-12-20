import java.sql.*;

public class TestCallableStatement {

    public static void main(String[] args) {


        String userName = "root";
        String password = "Aa12345678";
        String URL = "jdbc:mysql://localhost:3306/jdbcsample";

        Connection con = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {

            //載入驅動
            Class.forName("com.mysql.cj.jdbc.Driver");


            //建立連線
            con = DriverManager.getConnection(URL, userName, password);
            cstmt = con.prepareCall("{call get_sal_avg(?,?)}");

            cstmt.setDouble(1, 2000);
            cstmt.registerOutParameter(2, Types.DOUBLE);

            cstmt.execute();
            double avg = cstmt.getDouble(2);
            System.out.println(avg);





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
                if(cstmt != null)
                    cstmt.close();
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
