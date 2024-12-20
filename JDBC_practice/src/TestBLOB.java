import java.io.*;
import java.sql.*;

public class TestBLOB {

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

            String SQL = "select pic from club where id = ?";
            con = DriverManager.getConnection(URL, userName, password);

            pstmt = con.prepareStatement(SQL);
            pstmt.setInt(1, 4);
            rset = pstmt.executeQuery();
            rset.next();

            InputStream x = rset.getBinaryStream(1);

            File file = new File("C:/data/cat2.png");
            BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(file));
            int i;
            while((i = x.read()) != -1){
                bf.write(i);
            }


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
