package com.example.computermarket.Service;

import com.example.computermarket.Model.User;

import java.util.List;

public interface IComputerService {
    void register(User user);
    User login(String email, String password);


}
