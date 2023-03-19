package com.example.computermarket.Controller;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Model.User;
import com.example.computermarket.Service.ComputerService;
import com.example.computermarket.Service.IComputerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ComputerServlet", urlPatterns = "/computer")
public class ComputerServlet extends HttpServlet {
    IComputerService computerService = new ComputerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionComputer = request.getParameter("action");
        if (actionComputer == null) {
            actionComputer = "";
        }
        switch (actionComputer) {
            case "detail":
                showComputerDetail(request, response);
                break;
            case "delete":
                deleteComputer(request, response);
                break;
            case "create":
                showCreateComputer(request, response);
                break;
            case "update":
                showUpdateComputer(request, response);
                break;
            case "sort":
                sortByProducer(request, response);
                break;
            default:
                listComputer(request, response);
                break;
        }
    }

    private void sortByProducer(HttpServletRequest request, HttpServletResponse response) {
        List<Computer> computerList = computerService.sortByProduct();
        request.setAttribute("computerList", computerList);
        try {
            request.getRequestDispatcher("/computer/list_computer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showUpdateComputer(HttpServletRequest request, HttpServletResponse response) {
        int idPc = Integer.parseInt(request.getParameter("idPc"));
        Computer computer = computerService.findById(idPc);
        if (computer == null) {
            try {
                response.sendRedirect("/computer/error-404.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            request.setAttribute("computer", computer);
            try {
                request.getRequestDispatcher("/computer/update.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void showCreateComputer(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.sendRedirect("/computer/create.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteComputer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idPc"));
        computerService.deleteComputer(id);
        List<Computer> computerList = computerService.findAll();
        request.setAttribute("computerList", computerList);
        try {
            request.getRequestDispatcher("/computer/list_computer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showComputerDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idPc"));
        Computer computer = computerService.findById(id);
        request.setAttribute("computer", computer);
        try {
            request.getRequestDispatcher("/computer/detail.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listComputer(HttpServletRequest request, HttpServletResponse response) {
        List<Computer> computerList = computerService.findAll();
        request.setAttribute("computerList", computerList);
        try {
            request.getRequestDispatcher("/computer/list_computer.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void computerDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Computer computer = computerService.findById(id);
        request.setAttribute("computer", computer);
        try {
            request.getRequestDispatcher("/computer/detail.jsp").forward(request, response);
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
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "detail":
                computerDetail(request, response);
                break;
            case "create":
                createComputer(request, response);
                break;
            case "update":
                UpdateComputer(request, response);
                break;
            case "search":
                searchByProducer(request, response);
                break;
            default:
                listComputer(request, response);
                break;
        }
    }

    private void searchByProducer(HttpServletRequest request, HttpServletResponse response) {
        String producer = request.getParameter("producer");
        List<Computer> computerList = computerService.findByProducer(producer);

        if (computerList.isEmpty()) {
//            request.setAttribute("message", "Not Found");
            try {
                request.getRequestDispatcher("/computer/list_computer.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                request.setAttribute("computerList", computerList);
                request.getRequestDispatcher("/computer/list_computer.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void UpdateComputer(HttpServletRequest request, HttpServletResponse response) {
        int idPc = Integer.parseInt(request.getParameter("idPc"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String producer = request.getParameter("producer");
        String country = request.getParameter("country");
        String describe = request.getParameter("describe");
        String img = request.getParameter("img");
        Computer computer = new Computer(idPc, name, price, producer, country, describe, img);
        System.out.println(computer);
        if (computer == null) {
            try {
                response.sendRedirect("/computer/error-404.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            computerService.update(computer);
//            request.setAttribute("computer", computer);
            request.setAttribute("message", "Update successful");
            try {
                request.getRequestDispatcher("/computer/update.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createComputer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String producer = request.getParameter("producer");
        String country = request.getParameter("country");
        String describe = request.getParameter("describe");
        String img = request.getParameter("img");
        int idUser = 1;
        Computer computer = new Computer(name, price, producer, country, describe, img, idUser);
        computerService.create(computer);
        request.setAttribute("message", "Create successful");
        request.setAttribute("computer", computer);
        try {
            request.getRequestDispatcher("/computer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("computer", computer);
    }
}

