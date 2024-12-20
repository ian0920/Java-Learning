import java.io.*;
import java.sql.*;

public class TestCLUB {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;


        try {

            // 載入驅動
            Class.forName("com.mysql.cj.jdbc.Driver");


            //建立連線

            String userName = "root";
            String password = "Aa12345678";
            String URL = "jdbc:mysql://localhost:3306/jdbcsample";  //?serverTimezone=Asia/Taipe not working

            String SQL = "select intro from club where id = ?";
            con = DriverManager.getConnection(URL, userName, password);


            pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, 4);
            rset = pstmt.executeQuery();
            rset.next();

            String data = rset.getString(1);

            File file = new File("C:/data/cat.txt");
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));

            bf.write(data);

            bf.close();











        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(rset != null)
                    rset.close();
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
