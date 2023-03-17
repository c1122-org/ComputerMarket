package com.example.computermarket.Repository;

import com.example.computermarket.Model.Computer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ComputerRepository implements IComputerRepository{
    private static final String CREATE = "";
    private static final String UPDATE = "";
    @Override
    public boolean create(Computer computer) {
        Connection connection = DBRepository.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
            preparedStatement.setInt(1,computer.getId());
            preparedStatement.setString(2,computer.getName());
            preparedStatement.setDouble(3,computer.getPrice());
            preparedStatement.setString(4,computer.getProducer());
            preparedStatement.setString(5,computer.getCountry());
            preparedStatement.setString(6,computer.getDescribe());
            int num = preparedStatement.executeUpdate();
            return (num==1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Computer computer) {
        boolean rowUpdate = false;
        Connection connection = DBRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1,computer.getName());
            preparedStatement.setDouble(2,computer.getPrice());
            preparedStatement.setString(3,computer.getProducer());
            preparedStatement.setString(4,computer.getCountry());
            preparedStatement.setString(5,computer.getDescribe());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowUpdate;
    }
}
