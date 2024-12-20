package evt_coup.controller;

import evt_coup.model.EvtCoup;
import evt_coup.service.EvtCoupService;
import evt_coup.service.EvtCoupServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EventCoupon")
public class EvtCoupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        EvtCoupService service = new EvtCoupServiceImp();
        EvtCoup evtCoup = service.getEvtCoupById(id);
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("活動優惠券資訊: <br> ");
        out.println("活動優惠券編號： " + evtCoup.getId());
        out.println("<br> ");
        out.println("活動編號： " + evtCoup.getEvtId());
        out.println("<br> ");
        out.println("活動優惠券名稱： " + evtCoup.getEvtCoupName());
        out.println("<br> ");
        out.println("活動優惠券狀態： " + ((evtCoup.getStatus() == 0) ? "下架" : "上架"));
        out.println("<br> ");
        out.println("活動優惠券折扣類型： " + ((evtCoup.getType() == 0) ? "比例折扣" : "金額折扣"));
        out.println("<br> ");
        out.println("折扣金額： " + evtCoup.getDeduction());
        out.println("<br> ");
        out.println("折扣比例： " + evtCoup.getRatio());
        out.println("<br> ");
        out.println("適用日期(起)： " + evtCoup.getStartDate());
        out.println("<br> ");
        out.println("適用日期(迄)： " + evtCoup.getEndDate());
        out.println("<br> ");
        out.println("活動優惠券效期： " + evtCoup.getDuration());
        out.println("<br> ");
        out.println("活動優惠券適用門檻： " + evtCoup.getThreshold());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
