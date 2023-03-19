package com.example.computermarket.Service;

import com.example.computermarket.model.Computer;
import com.example.computermarket.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IComputerService {

    void register(User user);
    User login(String email, String password);

    void create (Computer computer);

    List<Computer> findAll();
    Computer findById(int id);
    boolean create (Computer computer);

    boolean update(Computer computer);
    List<Computer> findAll();

    Computer findById(int id) throws SQLException;

    List<Computer> findAll();

    void deleteComputer(int id) throws SQLException;
}
