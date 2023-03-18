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
    private static final String CREATE = "insert into pc( name_pc, price_pc, producer_pc,country_pc, describe_pc, img_pc,id_user) values(?, ?, ? ,?, ?, ?,?);";
    private static final String UPDATE = "";
    private static final String SELECT_DETAILS_PC_BY_ID = "select * from pc where  id = ?";
    private static final String DELETE_FORM_DETAILS_PC_WHERE_ID_PC = "delete from pc where id_pc = ?;";

    @Override
    public void create(Computer computer) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(CREATE);
                statement.setString(1, computer.getName());
                statement.setString(2, computer.getPrice());
                statement.setString(3, computer.getProducer());
                statement.setString(4, computer.getCountry());
                statement.setString(5, computer.getDescribe());
                statement.setString(6, computer.getImg());
                statement.setInt(7, computer.getIdUser());
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
    }

    @Override
    public boolean update(Computer computer) {
        boolean rowUpdate = false;
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

            preparedStatement.setString(1,computer.getName());
            preparedStatement.setString(2,computer.getPrice());
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
            if (id == computer.getIdPc()){
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
               statement = connection.prepareStatement("select * from pc");
               resultSet = statement.executeQuery();
               while (resultSet.next()){
                   int id = resultSet.getInt("id_pc");
                   String name = resultSet.getString("name_pc");
                   String price = resultSet.getString("price_pc");
                   String producer = resultSet.getString("producer_pc");
                   String country = resultSet.getString("country_pc");
                   String describe = resultSet.getString("describe_pc");
                   String img = resultSet.getString("img_pc");
                   int idUser = resultSet.getInt("id_user");
                   list.add(new Computer(id,name,price,producer,country,describe,img,idUser));
               }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;

    }

    @Override
    public void deleteComputer(int id) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null){
            try {
                statement = connection.prepareStatement(DELETE_FORM_DETAILS_PC_WHERE_ID_PC);
                statement.setInt(1,id);
                statement.executeUpdate();
            }catch (RuntimeException e){
                e.printStackTrace();
            }finally {
                try{
                    statement.close();
                    connection.close();
                }catch (RuntimeException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
