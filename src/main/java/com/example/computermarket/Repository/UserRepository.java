package com.example.computermarket.Repository;

import com.example.computermarket.Controller.DBConnection;
import com.example.computermarket.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    public static final String SET_UPDATE = "set foreign_key_checks = 0";
    private static final String UPDATE_USER = "UPDATE user set name =?, email =?, password =?, phone_number =? WHERE id_user =?";
    private static final String DELETE_USER = "DELETE FROM user WHERE id_user =?";
    private static final String SEARCH_BY_NAME = "SELECT * FROM user WHERE name LIKE ?";
    private static final String SORT_BY_NAME = "SELECT * FROM user ORDER BY name";

    @Override
    public void register(User user) {
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement("insert into user (name,email,password,phone_number) values (?,?,?,?)");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getPhoneNumber());
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
                        resultSet.getString(4),
                        resultSet.getString(4)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
                    int idUser = resultSet.getInt("id_user");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    String phoneNumber = resultSet.getString("phone_number");
                    user = new User(idUser, name, email, password, phoneNumber);
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
//    @Override
//    public List<User> findAllUser() {
//        Connection connection = DBConnection.getConnection();
//        PreparedStatement statement = null;
//        User user = null;
//        List<User> userList = new ArrayList<>();
//        if (connection != null) {
//            try {
//                statement = connection.prepareStatement("select name_pc,price_pc,user.phone_number,img_pc from pc join user on pc.id_user=user.id_user;");
//                ResultSet resultSet = statement.executeQuery();
//                while (resultSet.next()) {
//                    String name = resultSet.getString("name_pc");
//                    String price_pc = resultSet.getString("price_pc");
//                    String phone_number = resultSet.getString("user.phone_number");
//                    String img_pc = resultSet.getString("img_pc");
//                     user = new User(name, price_pc, phone_number, img_pc);
//                    userList.add(user);
//                }
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            } finally {
//                try {
//                    statement.close();
//                    connection.close();
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                DBConnection.close();
//            }
//        }
//        return userList;
//    }


    @Override
    public void insertUser(User user) {

    }

    @Override
    public User findUserById(int idUser) {
        List<User> userList = findAllUser();
        for (User user : userList) {
            if (user.getIdUser()== idUser) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findUserByName(String name) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> userListByName = new ArrayList<>();
        User user = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SEARCH_BY_NAME);
                statement.setString(1, name);
                resultSet = statement.executeQuery();
                while ((resultSet.next())) {
                    int idUser = resultSet.getInt("id_user");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    String phoneNumber = resultSet.getString("phone_number");
                    user = new User(idUser, name, email, password, phoneNumber);
                    userListByName.add(user);
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
        return userListByName;
    }


    @Override
    public void update(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_USER);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getPassword());
                statement.setString(4, user.getPhoneNumber());
                statement.setInt(5, user.getIdUser());
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
    public void delete(int idUser) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_USER);
                statement.setInt(1, idUser);
                statement1 = connection.prepareStatement(SET_UPDATE);
                statement1.executeUpdate();
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
    public List<User> sortByName() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        User user = null;
        List<User> userListBySortName = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SORT_BY_NAME);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int idUser = resultSet.getInt("id_user");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String password = resultSet.getString("password");
                    String phoneNumber = resultSet.getString("phone_number");
                    user = new User(idUser, name, email, password, phoneNumber);
                    userListBySortName.add(user);
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
        return userListBySortName;
    }
}
