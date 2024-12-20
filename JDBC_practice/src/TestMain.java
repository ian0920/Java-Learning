import java.sql.*;

public class TestMain {

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

            con = DriverManager.getConnection(URL, userName, password);


            //下SQL指令調取資料


            //1. 調取資料
            String sql_query = "select * from department where deptno = ?";

            pstmt = con.prepareStatement(sql_query);
            pstmt.setInt(1, 10);
            rset = pstmt.executeQuery();
            rset.next();

            System.out.println(rset.getInt(1) + rset.getString(2) + rset.getString(3));



            //2. 新增修改刪除

//            String sql_delete = "delete from department where deptno = ?";
//            pstmt = con.prepareStatement(sql_delete);
//            pstmt.setInt(1, 70);
//            pstmt.executeUpdate();
//            System.out.println("刪除成功");


            //3. 新增BLOB

//            File pic = new File("./pic/cat.png");
//            File text = new File("./txt/cat.txt");
//
//            InputStream in = new FileInputStream(pic);
//
//            byte[] data = new byte[(int)pic.length()];
//            in.read(data);
//
//            Reader r = new FileReader(text);
//            BufferedReader br = new BufferedReader(r);
//            StringBuilder sb = new StringBuilder();
//            String str = "";
//
//            while((str = br.readLine()) != null){
//                sb.append(str);
//                sb.append("\n");
//
//            }
//
//            br.close();
//            r.close();
//            in.close();
//
//
//
//
//            pstmt = con.prepareStatement("insert into club (id, cname, pic, intro) values (4, 'Meow', ?, ?) ");
//            pstmt.setBytes(1, data);
//            pstmt.setString(2, sb.toString());
//            pstmt.executeUpdate();
//
//            System.out.println("圖片及文字檔案上傳完成");











        } catch (ClassNotFoundException e) {
             e.printStackTrace();
        } catch (SQLException se){
            se.printStackTrace();
//        } catch (FileNotFoundException fe){
//            fe.printStackTrace();
//        } catch (IOException ioe){
//            ioe.printStackTrace();
        }finally{

            try {
                if(pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {

                if(con != null)
                    con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }


    }

}
