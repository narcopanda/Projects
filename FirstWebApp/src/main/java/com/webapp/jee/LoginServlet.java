package com.webapp.jee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    private LoginService service = new LoginService();

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
//
//        httpServletRequest.getRequestDispatcher("Where my jsp is").forward(httpServletRequest, httpServletResponse);
//
//        httpServletRequest.setAttribute("name", httpServletRequest.getParameter("name"));
//        httpServletRequest.setAttribute("password", httpServletRequest.getParameter("password"));
//        System.out.println(httpServletRequest.getParameter("name"));
        httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {

        String name = httpServletRequest.getParameter("name");
        String password = httpServletRequest.getParameter("password");

        boolean isUserValid = service.isUserValid(name, password);

        if(isUserValid){

            httpServletRequest.setAttribute("name", name);
            httpServletRequest.setAttribute("password", password);
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(httpServletRequest, httpServletResponse);
        }else {
            httpServletRequest.setAttribute("errorMessage", "Invalid UserName or Password");
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(httpServletRequest, httpServletResponse);

        }

    }
}