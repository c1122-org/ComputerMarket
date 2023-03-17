package com.example.computermarket.Service;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Model.User;

import java.util.List;

public interface IComputerService {

    void register(User user);
    User login(String email, String password);
    List<Computer> findAll();
    Computer findById(int id);
    boolean create (Computer computer);
    boolean update(Computer computer);

}
