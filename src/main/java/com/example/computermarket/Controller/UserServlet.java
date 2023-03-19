package com.example.computermarket.Controller;

import com.example.computermarket.Model.User;
import com.example.computermarket.Service.IUserService;
import com.example.computermarket.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    IUserService iUserService=new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        if(action==null){
            action = "";
        }
        switch (action){
            case "register":
                showCreate(request,response);
                break;
            case "logout":
                logout(request,response);
                break;
            default:
                break;
        }
    }
    private void showCreate(HttpServletRequest request, HttpServletResponse response){
        try {
            request.getRequestDispatcher("/view/register.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void logout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("nameAccount");
        try {
            response.sendRedirect("/view/home.jsp");
        } catch (IOException e) {
            e.printStackTrace();

import java.awt.image.PackedColorModel;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    IUserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "update":
                showUpdateUser(request, response);
                break;
            case "delete":
                break;
            case "view":
                break;
            default:
                showListUser(request, response);
                break;
        }
    }

    private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = service.findUserById(id);
//        if (user == null) {
//            try {
//                response.sendRedirect("/user/error-404.jsp");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
            request.setAttribute("user", user);
            try {
                request.getRequestDispatcher("/user/edit_user.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//        }
    }

    private void showListUser(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = service.findAllUser();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("/user/list_user.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        if(action==null){
            action = "";
        }
        switch (action){
            case "register":
                create(request,response);
                break;
            case "login":
                login(request,response);

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "update":
                updateUser(request, response);
                break;
            case "delete":
                break;
            case "view":

                break;
            default:
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(name,email,password);
        // lấy userList rồi so sánh email, nếu trùng  thì quay lại login
        iUserService.register(user);
        try {
            response.sendRedirect("/view/login.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void login(HttpServletRequest request, HttpServletResponse response){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = iUserService.login(email,password);
        Cookie cookie = new Cookie("email", email);
        cookie.setMaxAge(3600); // Thời gian tồn tại của cookie là 1 giờ
        response.addCookie(cookie);
        // thêm code để đọc cookie từ trình duyệt ng dùng (Cookie[] cookies = request.getCookies();
        //if (cookies != null) {
        //    for (Cookie cookie : cookies) {
        //        if (cookie.getName().equals("email")) {
        //            String email = cookie.getValue();
        //            // Sử dụng thông tin từ cookie để xử lý yêu cầu
        //            // ...
        //        }
        //    }
        //})
        if(user==null){
            try {
                response.sendRedirect("/view/login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("nameAccount",user);
                response.sendRedirect("/view/home.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }


    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
     int id = Integer.parseInt(request.getParameter("id"));
     User user = service.findUserById(id);
     service.update(user);
        try {
            request.getRequestDispatcher("/user/edit.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }
}
