package com.example.computermarket.Service;

import com.example.computermarket.Model.Computer;
import com.example.computermarket.Model.User;
import com.example.computermarket.Repository.ComputerRepository;
import com.example.computermarket.Repository.IComputerRepository;
import com.example.computermarket.Repository.IUserRepository;
import com.example.computermarket.Repository.UserRepository;

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
    public boolean create(Computer computer) {

        return iComputerRepository.create(computer);
    }

    @Override
    public boolean update(Computer computer) {
        return iComputerRepository.update(computer);
    }

    @Override
    public List<Computer> findAll() {
        return iComputerRepository.findAll();
    }
}
