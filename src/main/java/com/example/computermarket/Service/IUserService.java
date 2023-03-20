package com.example.computermarket.Service;

import com.example.computermarket.Model.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUser();
    void insertUser(User user);
    User findUserById(int id);
    List<User> findUserByName(String name);
    void update(User user);
    void delete(int id);
     List<User> sortByName();

    User login(String email, String password);
    void register(User user);


}
