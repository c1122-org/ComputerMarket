package com.example.computermarket.Repository;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface IComputerRepository {
    void create(Computer computer);
    void update(Computer computer);

    Computer findById(int id) ;

    List<Computer> findAll();

    void deleteComputer(int id);
    List<Computer> findByProducer(String producer);
    List<Computer> sortByProduct();
    List<Computer> findAllPcUser();
<<<<<<< HEAD

=======
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
}
