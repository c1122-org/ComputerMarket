package com.example.computermarket.Repository;

import com.example.computermarket.Model.User;

import java.util.List;

public interface IUserRepository {
    void register(User user);
    User login(String email, String password);
    List<User> findAllUser();
    void insertUser(User user);
    User findUserById(int id);
    User findUserByName(int name);
    void update(User user);
    void delete(int id);
    void sortByName();


}
