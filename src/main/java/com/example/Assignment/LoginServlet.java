package com.example.Assignment;

import com.example.Assignment.dao.UserDao;
import com.example.Assignment.models.LoginBean;
import com.oracle.tools.packager.Log;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",displayName = "LoginServlet", value =  "login",urlPatterns ={"/login"})
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        super.init();
        Log.debug("init LoginServlet");
        userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Log.debug("doPost");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setEmail(email);
        loginBean.setPassword(password);
        Log.debug(email);
        Log.debug(password);
        try {
            if (userDao.validate(loginBean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("dashboard.jsp");
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}