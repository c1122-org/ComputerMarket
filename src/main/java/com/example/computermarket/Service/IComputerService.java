package com.example.computermarket.Service;

import com.example.computermarket.Model.Computer;

import java.sql.SQLException;
import java.util.List;

public interface IComputerService {

<<<<<<< HEAD
    void create (Computer computer);
    void update(Computer computer);

    Computer findById(int id) ;

    List<Computer> findAll();

    void deleteComputer(int id) ;
    List<Computer> findByProducer(String producer);
    List<Computer> sortByProduct();
=======
    void register(User user);

    User login(String email, String password);


    void create(Computer computer);

    void update(Computer computer);

    Computer findById(int id);

    List<Computer> findAll();

    void deleteComputer(int id);

    List<Computer> findByProducer(String producer);

    List<Computer> sortByProduct();

>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
    List<Computer> findAllPcUser();
}