package com.example.computermarket.Repository;

import com.example.computermarket.Controller.DBConnection;
import com.example.computermarket.Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository{

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String UPDATE_USER = "UPDATE user set name = ?, email = ?, password =? WHERE id = ?";


    @Override
    public void register(User user) {
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("insert into user (name,email,password) values (?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User login(String email, String password) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBConnection.getConnection().prepareStatement("select * from user where email = ? and password =?");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                return new User(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    }


    @Override
    public List<User> findAllUser() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        User user = null;
        List<User> userList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SELECT_ALL_USERS);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    user = new User(id, name, email, password);
                    userList.add(user);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
        return userList;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public User findUserById(int id) {
        List<User> userList = findAllUser();
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User findUserByName(int name) {

        return null;
    }

    @Override
    public void update(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement.setString(1, user.getName());
                statement.setString(2,user.getEmail());
                statement.setString(3,user.getPassword());
                statement.setInt(4,user.getId());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void sortByName() {

    }
}

