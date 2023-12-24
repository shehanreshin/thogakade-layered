package dao.custom;

import dao.CrudDAO;
import dto.ItemDTO;
import entity.Customer;
import entity.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO extends CrudDAO<Item> {
    ItemDTO searchItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
}
