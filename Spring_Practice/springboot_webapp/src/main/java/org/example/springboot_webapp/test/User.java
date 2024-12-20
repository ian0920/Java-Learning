package org.example.springboot_webapp.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class User {

    /* 傳統Servlet寫法

    @RequestMapping("/login")
    public String login (HttpServletRequest request) {

        String account =request.getParameter("account");
        String password =request.getParameter("password");
        if(!account.isEmpty() && !password.isEmpty()){

            request.setAttribute("account",account);
            request.setAttribute("password",password);

            return "welcome.jsp";
        }

        return "error.jsp";
    }

    */

    @RequestMapping("/")
    public String homepage(){
        return "home";
    }


    // SpringBoot 寫法 Model物件傳參數 ViewResolver跳轉

    @RequestMapping("/login")
    public String login (@RequestParam("account") String myAccount, String password, Model model) {

        //request的傳入參數名稱若跟方法參數名稱相同，即可不需要再特別宣告@RequestParam

        if(!myAccount.isEmpty() && !password.isEmpty()){

            model.addAttribute("account", myAccount);
            model.addAttribute("password", password);

            return "welcome";
        }

        return "error";
    }


    //同時傳出model及view位置

//    @RequestMapping("/add")
//    public String add(Student student, Model model) {
//
//        System.out.println(student.getNum1());
//        System.out.println(student.getNum2());
//
//        int result = student.getNum1() + student.getNum2();
//
//        model.addAttribute("result", result);
//
//
////        int result = student.getNum1() + student.getNum2();
////        mv.addObject("result", result); //set model object
////        mv.setViewName("result"); //set view path
//
//
//        /*
//             return "redirect:/views/result.jsp" //redirect需要寫完整路徑，但無法傳遞參數
//             client request --> controller --> second request --> redirect URL
//        */
//
//        return "result";
//
//
//    }

    /*
        Redirect vs Forward

        Redirect: client request --> controller --> client second request --> redirect URL (url change)
        Forward: client request --> controller --> response page (url pattern remains as the request sent)

        RedirectAttribute
        1. addFlashAttribute (作用類似於暫時的 session)
           client request --> controller --> addFlashAttribute --> forward to second controller
           --> forward to render page

        2. addAttribute (attribute 會顯示在url)
            client request --> controller --> addAttribute --> redirect to render page
            --> fetch the data from the url attribute



    */

    @RequestMapping("/add")
    public String redirectWithAttribute (Student student, RedirectAttributes attr){

        int result = student.getNum1() + student.getNum2();

        attr.addFlashAttribute("student",student);
        attr.addFlashAttribute("result",result);
        return "redirect:result";
    }

    @RequestMapping("/result")
    public String showResult (){
        return "result";
    }

    /*

        Forward  vs Redirect

        Forward
            client send request --> server --> controller --> forward (req,res) --> jsp

         Redirect
            client send request --> server --> controller data( session ) --> redirect (req, res)
            --> client (receive req, res)--> second request --> url
     */







}
