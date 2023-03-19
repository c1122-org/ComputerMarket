package com.example.computermarket.Controller;

import com.example.computermarket.Model.Computer;
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
    ComputerService computerService = new ComputerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionComputer = request.getParameter("action");
        if (actionComputer == null){
            actionComputer = "";
        }
        try {
            switch (actionComputer){
                case "detail":
                    showComputerDetail(request,response);
                    break;
                case "delete":
                    deleteComputer(request,response);
                    break;
                case "create":
                    showCreateComputer(request,response);
                    break;
                default:
                    listComputer(request,response);
                    break;
        }
        }catch (RuntimeException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showCreateComputer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/computer/create.jsp");
    }

    private void deleteComputer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        computerService.deleteComputer(id);
        List<Computer> computerList = computerService.findAll();
        request.setAttribute("computerList",computerList);
        request.getRequestDispatcher("/computer/list_computer.jsp").forward(request,response);

    }

    private void showComputerDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Computer computer = computerService.findById(id);
        request.setAttribute("computer",computer);
        request.getRequestDispatcher("/computer/detail.jsp").forward(request,response);
    }

    private void listComputer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Computer> computerList = computerService.findAll();
        request.setAttribute("computerList",computerList);
        request.getRequestDispatcher("/computer/list_computer.jsp").forward(request,response);
    }

    private void computerDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Computer computer = computerService.findById(id);
        request.setAttribute("computer",computer);
        request.getRequestDispatcher("/computer/detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        try {
            switch (action){
                case "detail":
                    computerDetail(request,response);
                    break;
                case "create":
                    createComputer(request,response);
                    break;
                default:
                    listComputer(request,response);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

@WebServlet(name = "ComputerServlet", urlPatterns = "/computer")
public class ComputerServlet extends HttpServlet {
    IComputerService iComputerService = new ComputerService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionComputer = request.getParameter("actionComputer");
            if (actionComputer == null){
                actionComputer = "";
            }
            switch (actionComputer){
                case "create":
                    computerCreate(request, response);
                    break;
                case "update":
                    computerUpdate(request, response);
                    break;
            }
    }

    private void computerUpdate(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String producer = request.getParameter("producer");
        String country = request.getParameter("country");
        String describe = request.getParameter("describe");
        String img = request.getParameter("img");
        int id = Integer.parseInt(request.getParameter("id"));
        Computer computer = iComputerService.findById(id);
        computer.setName(name);
        computer.setPrice(price);
        computer.setProducer(producer);
        computer.setCountry(country);
        computer.setDescribe(describe);
        computer.setImg(img);
        iComputerService.update(computer);
        try {
            response.sendRedirect("/computer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void computerCreate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String producer = request.getParameter("producer");
        String country = request.getParameter("country");
        String describe = request.getParameter("describe");
        String img = request.getParameter("img");
        Computer computer = new Computer(id,name,price,producer,country,describe,img);
        iComputerService.create(computer);
        try {
            response.sendRedirect("/computer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionComputer = request.getParameter("actionComputer");
            if (actionComputer == null){
                actionComputer = "";
            }
            switch (actionComputer){
                case "create":
                    computerCreateForm(request, response);
                    break;
                case "update":
                    computerUpdateForm(request, response);
                    break;
            }
    }

    private void computerUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String producer = request.getParameter("producer");
        String country = request.getParameter("country");
        String describe = request.getParameter("describe");
        String img = request.getParameter("img");
        Computer computer = new Computer(id,name,price,producer,country,describe,img);
        iComputerService.update(computer);
        request.setAttribute("computer",computer);
        request.setAttribute("message","Create success");
        try {
            request.getRequestDispatcher("/computer/update.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void computerCreateForm(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String producer = request.getParameter("producer");
        String country = request.getParameter("country");
        String describe = request.getParameter("describe");
        String img = request.getParameter("img");
        Computer computer = new Computer(name,price,producer,country,describe,img);
        iComputerService.create(computer);
        request.setAttribute("message","Create success");
        request.setAttribute("computer",computer);
        try {
            request.getRequestDispatcher("/computer/create.jsp").forward(request,response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    private void createComputer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String producer = request.getParameter("producer");
        String country = request.getParameter("country");
        String describe = request.getParameter("describe");
        String img = request.getParameter("img");
        int idUser = 1;
        Computer computer = new Computer(name,price,producer,country,describe,img,idUser);
        computerService.create(computer);
        request.setAttribute("computer",computer);
        request.getRequestDispatcher("/computer/list_computer.jsp").forward(request,response);
    }
}
