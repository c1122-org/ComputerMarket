package com.example.computermarket.Controller;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Service.ComputerService;

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
                default:
                    listComputer(request,response);
                    break;
        }
        }catch (RuntimeException e){
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteComputer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        computerService.deleteComputer(id);
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
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
