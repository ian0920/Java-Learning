import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Hello")
public class Hello extends HttpServlet {

    public void doGet (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("Big5");
        res.setContentType("text/html; charset=Big5");

        PrintWriter out = res.getWriter();
        out.println("Hello World");
        out.println("test");


//        System.out.println(req.getContextPath());

    }


    public void doPost (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        doGet(req, res);
    }
}
