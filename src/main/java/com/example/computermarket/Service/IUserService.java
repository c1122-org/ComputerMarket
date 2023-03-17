package com.example.computermarket.Service;

import com.example.computermarket.Model.User;

public interface IUserService {
    void register(User user);
    User login(String email, String password);

}
