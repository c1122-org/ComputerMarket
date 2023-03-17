package com.example.computermarket.Repository;

import com.example.computermarket.Controller.DBConnection;
import com.example.computermarket.Model.Computer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputerRepository implements IComputerRepository{
    private static final String CREATE = "";
    private static final String UPDATE = "";
    private static final String SELECT_DETAILS_PC_BY_ID = "select * from details_pc where  id = ?";

    @Override
    public boolean create(Computer computer) {
        Connection connection = DBConnection.getConnection();

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
        Connection connection = DBConnection.getConnection();
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

    @Override
    public Computer findById(int id) throws SQLException {
        List<Computer> list = findAll();
        for (Computer computer : list){
            if (id == computer.getId()){
                return computer;
            }
        }return  null;

    }

    @Override
    public List<Computer> findAll() {
        List<Computer> list = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Computer computer = null;
        if (connection != null){
            try {
               statement = connection.prepareStatement("select * from details_pc");
               resultSet = statement.executeQuery();
               while (resultSet.next()){
                   int id = resultSet.getInt("id_pc");
                   String name = resultSet.getString("name_pc");
                   Double price = resultSet.getDouble("price_pc");
                   String producer = resultSet.getString("producer_pc");
                   String country = resultSet.getString("country_pc");
                   String describe = resultSet.getString("describe_pc");
                   list.add(new Computer(id,name,price,producer,country,describe));
               }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;

    }

    @Override
    public void deleteComputer(int id) throws SQLException {
        Computer computer = findById(id);
        
    }
}
