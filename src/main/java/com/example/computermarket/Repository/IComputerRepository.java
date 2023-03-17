package com.example.computermarket.Repository;

import com.example.computermarket.Model.Computer;

import java.util.List;

public interface IComputerRepository {
    boolean create(Computer computer);
    boolean update(Computer computer);

    List<Computer> findAll();
}
