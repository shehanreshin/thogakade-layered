package dao.custom.impl;

import dao.util.CrudUtil;
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
        String sql = "INSERT INTO item VALUES(?,?,?,?)";
        return CrudUtil.execute(sql, entity.getCode(), entity.getDescription(), entity.getUnitPrice(), entity.getQtyOnHand());
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        List<Item> itemList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM item");

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
        String sql = "UPDATE item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?";
        return CrudUtil.execute(sql, entity.getDescription(), entity.getUnitPrice(), entity.getQtyOnHand(), entity.getCode());
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE from item WHERE code=?", code);
    }
}
