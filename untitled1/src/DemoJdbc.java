import java.sql.Connection;
import java.sql.DriverManager;

public class DemoJdbc {

    public static void main(String[] args) throws Exception {
        /*
            import package
            load and register
            create connection
            create statement
            execute statement
            process the results
            close
         */

        String url = "jdbc:mysql://localhost:3306/jdbc_learning?serverTimezone=Asia/Taipei";
        String username = "root";
        String password ="Aa12345678";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connection Established");

        connection.close();


    }
}
