package com.example.computermarket.Repository;

import com.example.computermarket.Controller.DBConnection;
import com.example.computermarket.Model.Computer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class ComputerRepository implements IComputerRepository {
    private static final String CREATE = "insert into computer( name, price, producer,country, describe, img) values(?, ?, ? ,?, ?, ?);";
    private static final String UPDATE = "";
    private static final String SELECT_ALL_COMPUTER = "";

    @Override

    public boolean create(Computer computer) {
        Connection connection = DBConnection.getConnection();

    public List<Computer> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Computer> computerList = new ArrayList<>();
        if (connection != null){
            try {
                statement = connection.prepareStatement(SELECT_ALL_COMPUTER);
                resultSet = statement.executeQuery();
                Computer computer = null;
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    String producer = resultSet.getString("producer");
                    String country = resultSet.getString("country");
                    String describe = resultSet.getString("describe");
                    String img = resultSet.getString("img");
                    computer = new Computer(id,name,price,producer,country,describe,img);
                    computerList.add(computer);
                }
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                try {
                    resultSet.close();
                    statement.close();
                    DBConnection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return computerList;
    }

    @Override
    public Computer findById(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBConnection.getConnection().prepareStatement("");
            preparedStatement.setInt(1, id);
            Computer computer;
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                computer = new Computer();
                computer.setId(resultSet.getInt("id"));
                computer.setName(resultSet.getString("name"));
                computer.setPrice(resultSet.getDouble("price"));
                computer.setProducer(resultSet.getString("producer"));
                computer.setCountry(resultSet.getString("country"));
                computer.setDescribe(resultSet.getString("describe"));
                computer.setImg(resultSet.getString("img"));
                return computer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean create(Computer computer) {
//        Connection connection = DBConnection.getConnection();
//
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
//            preparedStatement.setInt(1, computer.getId());
//            preparedStatement.setString(2, computer.getName());
//            preparedStatement.setDouble(3, computer.getPrice());
//            preparedStatement.setString(4, computer.getProducer());
//            preparedStatement.setString(5, computer.getCountry());
//            preparedStatement.setString(6, computer.getDescribe());
//            preparedStatement.setString(7, computer.getImg());
//            int num = preparedStatement.executeUpdate();
//            return (num == 1);
//        } catch (SQLException e) {
//            e.printStackTrace();

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(CREATE);
                statement.setString(1, computer.getName());
                statement.setDouble(2, computer.getPrice());
                statement.setString(3, computer.getProducer());
                statement.setString(4, computer.getCountry());
                statement.setString(5, computer.getDescribe());
                statement.setString(6, computer.getImg());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return false;
    }

    @Override
    public boolean update(Computer computer) {
        boolean rowUpdate = false;
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1, computer.getName());
            preparedStatement.setDouble(2, computer.getPrice());
            preparedStatement.setString(3, computer.getProducer());
            preparedStatement.setString(4, computer.getCountry());
            preparedStatement.setString(5, computer.getDescribe());
            preparedStatement.setString(6, computer.getImg());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdate;
//        Connection connection = DBConnection.getConnection();
//        PreparedStatement statement = null;
//        if (connection != null) {
//            try {
//                statement = connection.prepareStatement(UPDATE);
//                statement.setInt(1, computer.getId());
//                statement.setString(2, computer.getName());
//                statement.setDouble(3, computer.getPrice());
//                statement.setString(4, computer.getProducer());
//                statement.setString(5, computer.getCountry());
//                statement.setString(6, computer.getDescribe());
//                statement.setString(7, computer.getImg());
//
//                statement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                DBConnection.close();
//            }
//        }
//    }
//        return statement;
//    }
    }

    @Override
    public List<Computer> findAll() {
        List<Computer> computerList = new ArrayList<>();
        PreparedStatement preparedStatement =null;
        try {
            preparedStatement = DBRepository.getConnection().
                    prepareStatement("select * from computer");
            ResultSet resultSet =preparedStatement.executeQuery();
            Computer computer;
            while (resultSet.next()) {
                computer = new Computer();
                computer.setId(resultSet.getInt("id_cp"));
                computer.setName(resultSet.getString("name"));
                computer.setPrice(resultSet.getDouble("price"));
                computer.setProducer(resultSet.getString("producer"));
                computer.setCountry(resultSet.getString("country"));
                computer.setDescribe(resultSet.getString("describe"));
                computerList.add(computer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return computerList;
    }
}
