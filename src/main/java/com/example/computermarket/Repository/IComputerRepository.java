package com.example.computermarket.Repository;

import com.example.computermarket.Model.Computer;

public interface IComputerRepository {
    boolean create(Computer computer);
    boolean update(Computer computer);
}
