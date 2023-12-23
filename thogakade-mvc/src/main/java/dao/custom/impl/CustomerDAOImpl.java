package dao.custom.impl;

import db.DBConnection;
import dto.CustomerDTO;
import dao.custom.CustomerDAO;
import entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer entity) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO customer VALUES(?,?,?,?)");
        preparedStatement.setString(1,entity.getId());
        preparedStatement.setString(2,entity.getName());
        preparedStatement.setString(3,entity.getAddress());
        preparedStatement.setDouble(4,entity.getSalary());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM customer");
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            customerList.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4)
            ));
        }

        return customerList;
    }

    @Override
    public boolean update(Customer entity) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("UPDATE customer SET name=?, address=?, salary=? WHERE id=?");
        preparedStatement.setString(1,entity.getName());
        preparedStatement.setString(2,entity.getAddress());
        preparedStatement.setDouble(3,entity.getSalary());
        preparedStatement.setString(4,entity.getId());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("DELETE from customer WHERE id=?");
        preparedStatement.setString(1,id);
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public Customer searchCustomer(Customer entity) throws SQLException, ClassNotFoundException {
        return null;
    }
}
