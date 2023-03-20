package com.example.computermarket.Service;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Repository.ComputerRepository;
import com.example.computermarket.Repository.IComputerRepository;


import java.sql.SQLException;
import java.util.List;


import java.util.List;

public class ComputerService implements IComputerService {
    IComputerRepository iComputerRepository = new ComputerRepository();
<<<<<<< HEAD


    @Override
    public void create(Computer computer) {
        iComputerRepository.create(computer);
    }

    @Override
    public void update(Computer computer) {
        iComputerRepository.update(computer);
    }

    @Override
    public Computer findById(int id){
        return iComputerRepository.findById(id);
    }

    @Override
    public List<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
=======
    IUserRepository userRepository = new UserRepository();


    @Override
    public void create(Computer computer) {
        iComputerRepository.create(computer);
    }

    @Override
    public void register(User user) {

    }

    @Override

    public User login(String email, String password) {
        return userRepository.login(email, password);
    }

    @Override
    public void update(Computer computer) {
        iComputerRepository.update(computer);
    }

    @Override
    public Computer findById(int id) {
        return iComputerRepository.findById(id);
    }

    @Override
    public List<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
    public void deleteComputer(int id) {
        iComputerRepository.deleteComputer(id);
    }

    @Override
    public List<Computer> findByProducer(String producer) {
        return iComputerRepository.findByProducer(producer);
    }

    @Override
    public List<Computer> sortByProduct() {
        return iComputerRepository.sortByProduct();
    }

    @Override
    public List<Computer> findAllPcUser() {
        return iComputerRepository.findAllPcUser();
    }
}