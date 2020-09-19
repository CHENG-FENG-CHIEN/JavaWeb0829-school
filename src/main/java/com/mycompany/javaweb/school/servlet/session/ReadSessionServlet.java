package com.mycompany.javaweb.school.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servlet/session/read")
public class ReadSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        if(session != null ){
        out.print("Read session ok !");
        out.println("session Id :" + session.getId());
        //讀取 session attribute 資料
            Enumeration<String> enums = session.getAttributeNames();
            while (enums.hasMoreElements()) {
                String name = enums.nextElement();
               out.println(name + " : " + session.getAttribute(name));
            }
        } else {
            out.print("None session !");
        }
    }
    
}
    

