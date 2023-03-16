package com.example.computermarket.Repository;

import com.example.computermarket.Model.User;

public interface IUserRepository {
    void register(User user);
    User login(String email, String password);
}
