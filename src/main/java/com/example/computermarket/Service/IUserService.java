package com.example.computermarket.Service;

import com.example.computermarket.Model.User;


public interface IUserService {
    void register(User user);
    User login(String email, String password);


import java.util.List;

public interface IUserService {
    List<User> findAllUser();
    void insertUser(User user);
    User findUserById(int id);
    User findUserByName(int name);
    void update(User user);
    void delete(int id);
    void sortByName();

}
