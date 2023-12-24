package dao.custom.impl;

import dao.util.CrudUtil;
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
        String sql = "INSERT INTO customer VALUES(?,?,?,?)";
        return CrudUtil.execute(sql, entity.getId(), entity.getName(), entity.getAddress(), entity.getSalary());
    }

    @Override
    public List<Customer> getAll() throws SQLException, ClassNotFoundException {
        List<Customer> customerList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM customer");

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
        String sql = "UPDATE customer SET name=?, address=?, salary=? WHERE id=?";
        return CrudUtil.execute(sql, entity.getName(), entity.getAddress(), entity.getSalary(), entity.getId());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE from customer WHERE id=?";
        return CrudUtil.execute(sql, id);
    }

    @Override
    public Customer searchCustomer(Customer entity) throws SQLException, ClassNotFoundException {
        return null;
    }
}
