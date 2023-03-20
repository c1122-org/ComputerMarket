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
            case "register":
                showCreate(request, response);
                break;
            case "logout":
                logout(request, response);
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

    /**
     * Function: show register form
     * Create: HoangPT
     * Date create: 18/03/2023
     */
    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/register.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function: log out
     * Create: HoangPT
     * Date create: 19/03/2023
     */
    private void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("nameAccount");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("email") || cookie.getName().equals("password")) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
        try {
            response.sendRedirect("/computer/list_computer.jsp");
        } catch (IOException e) {
            e.printStackTrace();
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

    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        if (httpSession.getAttribute("emailAccount")==null){
            httpSession.setAttribute("emailAccount","");
        }
        if (!httpSession.getAttribute("emailAccount").equals("admin@gmail.com")) {
            response.sendRedirect("/computer");
        } else {
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
            case "register":
                create(request, response);
                break;
            case "login":
                login(request, response);
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

    /**
     * Function: register
     * Create: HoangPT
     * Date create: 17/03/2023
     */
    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        User user = new User(name, email, password, phoneNumber);
        List<User> userList = service.findAllUser();
        boolean flag = true;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getEmail().equals(email)) {
                flag = false;
                request.setAttribute("registerFail", "Email đã tồn tại");
                request.getRequestDispatcher("/user/register.jsp").forward(request, response);
                break;
            }
        }
        // lấy userList rồi so sánh email, nếu trùng  thì quay lại login, thông báo đã trùng email

        if (flag) {
            service.register(user);
            response.sendRedirect("/computer");
        }
    }

    /**
     * Function: login
     * Create: HoangPT
     * Date create: 17/03/2023
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = service.login(email, password);
        if (user == null) {
            try {
                request.setAttribute("loginFail", "Đăng nhập thất bại");
                request.getRequestDispatcher("/user/login.jsp").forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            try {
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("emailAccount", email);
                httpSession.setAttribute("nameAccount", user);
                Cookie cookie2 = new Cookie("email", user.getEmail());
                cookie2.setMaxAge(3600);
                response.addCookie(cookie2);
                Cookie cookie3 = new Cookie("password", user.getPassword());
                cookie3.setMaxAge(3600);
                response.addCookie(cookie3);
                if (user.getEmail().equals("admin@gmail.com")) {
                    response.sendRedirect("/user");
                } else {
                    response.sendRedirect("/computer");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        String phoneNumber = request.getParameter("phoneNumber");
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
