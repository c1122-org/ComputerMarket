package com.example.computermarket.Controller;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Service.ComputerService;
import com.example.computermarket.Service.IComputerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
}
