package dao.custom.impl;

import db.DBConnection;
import dto.ItemDTO;
import dao.custom.ItemDAO;
import entity.Item;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ItemDTO searchItem(ItemDTO itemDTO) {
        return null;
    }

    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
        preparedStatement.setString(1,entity.getCode());
        preparedStatement.setString(2,entity.getDescription());
        preparedStatement.setDouble(3,entity.getUnitPrice());
        preparedStatement.setInt(4,entity.getQtyOnHand());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        List<Item> itemList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM item");
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            itemList.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getInt(4)
            ));
        }

        return itemList;
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("UPDATE item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        preparedStatement.setString(1,entity.getDescription());
        preparedStatement.setDouble(2,entity.getUnitPrice());
        preparedStatement.setInt(3,entity.getQtyOnHand());
        preparedStatement.setString(4,entity.getCode());
        return preparedStatement.executeUpdate()>0;
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("DELETE from item WHERE code=?");
        preparedStatement.setString(1,code);
        return preparedStatement.executeUpdate()>0;
    }
}
