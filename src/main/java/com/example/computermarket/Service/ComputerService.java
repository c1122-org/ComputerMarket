package com.example.computermarket.Service;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Model.User;
import com.example.computermarket.Repository.ComputerRepository;
import com.example.computermarket.Repository.IComputerRepository;
import com.example.computermarket.Repository.IUserRepository;
import com.example.computermarket.Repository.UserRepository;


import java.sql.SQLException;


import java.util.List;

public class ComputerService implements  IComputerService{
    IComputerRepository iComputerRepository = new ComputerRepository();
    IUserRepository userRepository=new UserRepository();
    @Override
    public void register(User user) {
        userRepository.register(user);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.login(email,password);
    }

    @Override
<<<<<<< HEAD
    public void create(Computer computer) {
=======
    public List<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public Computer findById(int id) {
        return iComputerRepository.findById(id);
    }

    @Override
    public boolean create(Computer computer) {
>>>>>>> 6dd04988e49320393894aa185de7bd0ee22139ce

        iComputerRepository.create(computer);
    }

    @Override
    public boolean update(Computer computer) {
        return iComputerRepository.update(computer);
    }

    @Override

    public Computer findById(int id) throws SQLException {
            return iComputerRepository.findById(id);
    }

    @Override
    public List<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public void deleteComputer(int id) throws SQLException {
        iComputerRepository.deleteComputer(id);
    }

    public List<Computer> findAll() {
        return iComputerRepository.findAll();
    }

}
