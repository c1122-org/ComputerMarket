package com.example.computermarket.Controller;

import com.example.computermarket.Model.User;
import com.example.computermarket.Service.IUserService;
import com.example.computermarket.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
