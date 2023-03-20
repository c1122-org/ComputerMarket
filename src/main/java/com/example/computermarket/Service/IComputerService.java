package com.example.computermarket.Service;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IComputerService {

    void register(User user);

    User login(String email, String password);


    void create(Computer computer);

    void update(Computer computer);

    Computer findById(int id);

    List<Computer> findAll();

    void deleteComputer(int id);

    List<Computer> findByProducer(String producer);

    List<Computer> sortByProduct();

    List<Computer> findAllPcUser();
}