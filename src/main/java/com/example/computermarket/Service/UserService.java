package com.example.computermarket.Service;

import com.example.computermarket.Model.User;
import com.example.computermarket.Repository.ComputerRepository;
import com.example.computermarket.Repository.IComputerRepository;
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
        return null;
    }

    @Override
    public User findUserByName(int name) {
        return null;
    }

    @Override
    public void update(User user) {
        repository.update(user);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void sortByName() {

    }
}
