package com.example.computermarket.Service;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IComputerService {
    void register(User user);
    User login(String email, String password);
    void create (Computer computer);
    boolean update(Computer computer);

    Computer findById(int id) throws SQLException;

    List<Computer> findAll();

    void deleteComputer(int id) throws SQLException;
}
