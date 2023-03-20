package com.example.computermarket.Service;

import com.example.computermarket.Model.User;
import com.example.computermarket.Repository.IUserRepository;
import com.example.computermarket.Repository.UserRepository;

import java.util.List;

public class UserService implements IUserService {
    private IUserRepository repository = new UserRepository();

    @Override
    public List<User> findAllUser() {
        return repository.findAllUser();
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public User findUserById(int id) {
        return repository.findUserById(id);
    }

    @Override
    public List<User> findUserByName(String name) {
        return repository.findUserByName(name);
    }

    @Override
    public void update(User user) {
        repository.update(user);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public List<User> sortByName() {
  return repository.sortByName();
    }

    @Override
    public User login(String email, String password) {
        return  repository.login(email, password);
    }

    @Override
    public void register(User user) {
repository.register(user);
    }

}
