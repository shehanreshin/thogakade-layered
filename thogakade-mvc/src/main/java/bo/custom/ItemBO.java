package bo.custom;

import bo.SuperBO;
import dto.CustomerDTO;
import dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {
    boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    List<ItemDTO> allItems() throws SQLException, ClassNotFoundException;
}
