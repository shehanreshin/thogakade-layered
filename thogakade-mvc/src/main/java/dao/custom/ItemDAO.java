package dao.custom;

import dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
    boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    List<ItemDTO> allItems() throws SQLException, ClassNotFoundException;
    ItemDTO searchItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
}
