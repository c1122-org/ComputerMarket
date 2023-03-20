package com.example.computermarket.Controller;

import com.example.computermarket.Model.User;
import com.example.computermarket.Service.IUserService;
import com.example.computermarket.Service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    IUserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
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
                showDeleteForm(request, response);
                break;
            case "view":
                showViewUser(request, response);
                break;
            case "sort":
                sortByName(request, response);
                break;
            default:
                showListUser(request, response);
                break;
        }
    }

    private void sortByName(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = service.sortByName();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("/user/list_user.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<User> userList = service.findUserByName(name);

        if (userList.isEmpty()) {
            request.setAttribute("message", "Not Found");
            try {
                request.getRequestDispatcher("/user/list_user.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                request.setAttribute("userList", userList);
                request.getRequestDispatcher("/user/list_user.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void showViewUser(HttpServletRequest request, HttpServletResponse response) {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        User user = service.findUserById(idUser);
        request.setAttribute("user", user);
        try {
            request.getRequestDispatcher("/user/view_user.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        User user = service.findUserById(idUser);
        if (user == null) {
            try {
                response.sendRedirect("/user/error-404.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            request.setAttribute("user", user);
            try {
                request.getRequestDispatcher("/user/delete_user.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        User user = service.findUserById(idUser);
        if (user == null) {
            try {
                response.sendRedirect("/user/error-404.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            request.setAttribute("user", user);
            try {
                request.getRequestDispatcher("/user/edit_user.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
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
                deleteUser(request, response);
                break;
            case "search":
                searchByName(request, response);
                break;
            default:
                break;
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        service.delete(idUser);
        try {
            response.sendRedirect("/user");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) {
        int idUser = Integer.parseInt(request.getParameter("idUser"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber= request.getParameter("phoneNumber");
        User user = new User(idUser, name, email, password, phoneNumber);
        if (user == null) {
            try {
                response.sendRedirect("/user/error-404.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            service.update(user);
            request.setAttribute("user", user);
            request.setAttribute("message", "Update successful");
            try {
                request.getRequestDispatcher("/user/edit_user.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
