package com.example.computermarket.Service;

import com.example.computermarket.Model.Computer;

import java.sql.SQLException;
import java.util.List;

public interface IComputerService {

    void create (Computer computer);
    void update(Computer computer);

    Computer findById(int id) ;

    List<Computer> findAll();

    void deleteComputer(int id) ;
    List<Computer> findByProducer(String producer);
    List<Computer> sortByProduct();
    List<Computer> findAllPcUser();
}