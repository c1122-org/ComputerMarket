package com.example.computermarket.Repository;

import com.example.computermarket.Model.Computer;


import java.sql.SQLException;

import java.util.List;

public interface IComputerRepository {
    List<Computer> findAll();
    Computer findById(int id);
    boolean create(Computer computer);
    boolean update(Computer computer);

    Computer findById(int id) throws SQLException;

    List<Computer> findAll();

    void deleteComputer(int id) throws SQLException;

    List<Computer> findAll();

}
