package com.example.computermarket.Service;

import com.example.computermarket.Model.User;
import com.example.computermarket.Repository.IUserRepository;
import com.example.computermarket.Repository.UserRepository;

public class ComputerService implements  IComputerService{
    IUserRepository userRepository=new UserRepository();
    @Override
    public void register(User user) {
        userRepository.register(user);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.login(email,password);
    }
}
