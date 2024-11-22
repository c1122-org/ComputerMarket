package com.example.computermarket.Repository;

import com.example.computermarket.Controller.DBConnection;
import com.example.computermarket.Model.Computer;
import com.example.computermarket.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

public class ComputerRepository implements IComputerRepository {
    private static final String CREATE = "insert into pc( name_pc, price_pc, producer_pc,country_pc, describe_pc, img_pc,id_user)value(?, ?, ? ,?, ?, ?,?);";
    private static final String SELECT_DETAILS_PC_BY_ID = "select * from pc where  id = ?";
    private static final String DELETE_FORM_DETAILS_PC_WHERE_ID_PC = "delete from pc where id_pc = ?;";
    private static final String UPDATE_PC_SQL = "UPDATE pc SET name_pc =?, price_pc = ?, producer_pc = ?, country_pc = ?, describe_pc= ?, img_pc = ? WHERE id_pc = ?;";
    private static final String SEARCH_BY_PRODUCER = "SELECT * FROM pc WHERE producer_pc LIKE ?";
    private static final String SORT_BY_PRODUCER = "SELECT * FROM pc ORDER BY producer_pc";
    private static final String JOIN_USER_PC = "SELECT pc.id_pc, pc.name_pc, pc.price_pc, pc.producer_pc, pc.country_pc, pc.describe_pc, pc.img_pc, user.name, user.phone_number from pc inner join user on pc.id_user = user.id_user;";

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
                statement.setInt(7, 1);
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
    public void update(Computer computer) {

=======

public class ComputerRepository implements IComputerRepository {
    private static final String CREATE = "insert into pc( name_pc, price_pc, producer_pc,country_pc, describe_pc, img_pc,id_user)value(?, ?, ? ,?, ?, ?,?);";
    private static final String SELECT_DETAILS_PC_BY_ID = "select * from pc where  id = ?";
    private static final String DELETE_FORM_DETAILS_PC_WHERE_ID_PC = "delete from pc where id_pc = ?;";
    private static final String UPDATE_PC_SQL = "UPDATE pc SET name_pc =?, price_pc = ?, producer_pc = ?, country_pc = ?, describe_pc= ?, img_pc = ? WHERE id_pc = ?;";
    private static final String SEARCH_BY_PRODUCER = "SELECT * FROM pc WHERE producer_pc LIKE ?";
    private static final String SORT_BY_PRODUCER = "SELECT * FROM pc ORDER BY producer_pc";
    private static final String JOIN_USER_PC = "SELECT pc.id_pc, pc.name_pc, pc.price_pc, pc.producer_pc, pc.country_pc, pc.describe_pc, pc.img_pc, user.name, user.phone_number from pc inner join user on pc.id_user = user.id_user;";

    //    @Override
//    public List<Computer> findAll() {
//        Connection connection = DBConnection.getConnection();
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        List<Computer> computerList = new ArrayList<>();
//        if (connection != null){
//            try {
//                statement = connection.prepareStatement(SELECT_ALL_COMPUTER);
//                resultSet = statement.executeQuery();
//                Computer computer = null;
//                while (resultSet.next()){
//                    int id = resultSet.getInt("id");
//                    String name = resultSet.getString("name");
//                    double price = resultSet.getDouble("price");
//                    String producer = resultSet.getString("producer");
//                    String country = resultSet.getString("country");
//                    String describe = resultSet.getString("describe");
//                    String img = resultSet.getString("img");
//                    computer = new Computer(id,name,price,producer,country,describe,img);
//                    computerList.add(computer);
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }finally {
//                try {
//                    resultSet.close();
//                    statement.close();
//                    DBConnection.close();
//                }catch (SQLException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//        return computerList;
//    }
    public Computer findById(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DBConnection.getConnection().prepareStatement("");
            preparedStatement.setInt(1, id);
            Computer computer;
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                computer = new Computer();
                computer.setIdPc(resultSet.getInt("id"));
                computer.setName(resultSet.getString("name"));
                computer.setPrice(resultSet.getString("price"));
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
//    public void create(Computer computer) {
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

    public void create(Computer computer) {
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
<<<<<<< HEAD
                statement = connection.prepareStatement(UPDATE_PC_SQL);
=======
                statement = connection.prepareStatement(CREATE);
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
                statement.setString(1, computer.getName());
                statement.setString(2, computer.getPrice());
                statement.setString(3, computer.getProducer());
                statement.setString(4, computer.getCountry());
                statement.setString(5, computer.getDescribe());
                statement.setString(6, computer.getImg());
<<<<<<< HEAD
                statement.setInt(7, computer.getIdPc());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
=======
                statement.setInt(7, 1);
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
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
            }
        }
    }

    @Override
<<<<<<< HEAD
    public Computer findById(int id) {
        List<Computer> list = findAllPcUser();
        for (Computer computer : list) {
            if (id == computer.getIdPc()) {
                return computer;
            }
        }
        return null;
=======
    public void update(Computer computer) {

        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UPDATE_PC_SQL);
                statement.setString(1, computer.getName());
                statement.setString(2, computer.getPrice());
                statement.setString(3, computer.getProducer());
                statement.setString(4, computer.getCountry());
                statement.setString(5, computer.getDescribe());
                statement.setString(6, computer.getImg());
                statement.setInt(7, computer.getIdPc());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
    }

    @Override
    public List<Computer> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Computer> list = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement("select * from pc");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_pc");
                    String name = resultSet.getString("name_pc");
                    String price = resultSet.getString("price_pc");
                    String producer = resultSet.getString("producer_pc");
                    String country = resultSet.getString("country_pc");
                    String describe = resultSet.getString("describe_pc");
                    String img = resultSet.getString("img_pc");
                    int idUser = resultSet.getInt("id_user");
                    list.add(new Computer(id, name, price, producer, country, describe, img, idUser));
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
        return list;
    }

    @Override
    public void deleteComputer(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_FORM_DETAILS_PC_WHERE_ID_PC);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (RuntimeException | SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                    connection.close();
                } catch (RuntimeException | SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<Computer> findByProducer(String producer) {
        List<Computer> computerList = findAll();
        System.out.println(computerList.size());
        List<Computer> list = new ArrayList<>();
        for (Computer computer : computerList) {
            if (computer.getProducer().equals(producer)) {
                list.add(computer);
            }
        }
        return list;
    }

    @Override
    public List<Computer> sortByProduct() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        List<Computer> listSortProducer = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(SORT_BY_PRODUCER);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_pc");
                    String name = resultSet.getString("name_pc");
                    String price = resultSet.getString("price_pc");
                    String producer = resultSet.getString("producer_pc");
                    String country = resultSet.getString("country_pc");
                    String describe = resultSet.getString("describe_pc");
                    String img = resultSet.getString("img_pc");
                    int idUser = resultSet.getInt("id_user");
                    listSortProducer.add(new Computer(id, name, price, producer, country, describe, img, idUser));
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
        return listSortProducer;
    }

    @Override
    public List<Computer> findAllPcUser() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        List<Computer> computerList = new ArrayList<>();
<<<<<<< HEAD
        ResultSet resultSet =null;
=======
        ResultSet resultSet = null;
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
        if (connection != null) {
            try {
                statement = connection.prepareStatement(JOIN_USER_PC);
                resultSet = statement.executeQuery();
<<<<<<< HEAD
                while (resultSet.next()){
                   int idPc = resultSet.getInt("id_pc");
                   String name = resultSet.getString("name_pc");
=======
                while (resultSet.next()) {
                    int idPc = resultSet.getInt("id_pc");
                    String name = resultSet.getString("name_pc");
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
                    String price = resultSet.getString("price_pc");
                    String producer = resultSet.getString("producer_pc");
                    String country = resultSet.getString("country_pc");
                    String describe = resultSet.getString("describe_pc");
                    String img = resultSet.getString("img_pc");
                    String nameUser = resultSet.getString("name");
                    String phoneNumber = resultSet.getString("phone_number");
<<<<<<< HEAD
                    User user = new User(nameUser,phoneNumber);
=======
                    User user = new User(nameUser, phoneNumber);
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
                    Computer computer = new Computer(idPc, name, price, producer, country, describe, img, user);
                    computerList.add(computer);
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
<<<<<<< HEAD
               DBConnection.close();
=======
                DBConnection.close();
>>>>>>> e8b82aaabdaee539b44dcb87c3c96a4550894a7f
            }
        }
        return computerList;
    }
}