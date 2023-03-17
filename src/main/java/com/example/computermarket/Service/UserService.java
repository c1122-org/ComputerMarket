package com.example.computermarket.Service;

import com.example.computermarket.Model.User;
import com.example.computermarket.Repository.IUserRepository;
import com.example.computermarket.Repository.UserRepository;

public class UserService implements  IUserService{
    IUserRepository iUserRepository=new UserRepository();
    @Override
    public void register(User user) {
        iUserRepository.register(user);
    }

    @Override
    public User login(String email, String password) {
        return iUserRepository.login(email, password);
    }
}
