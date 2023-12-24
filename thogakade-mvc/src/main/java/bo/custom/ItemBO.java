package bo.custom;

import dto.CustomerDTO;
import dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemBO<T> {
    boolean saveItem(T dto) throws SQLException, ClassNotFoundException;
    boolean updateItem(T dto) throws SQLException, ClassNotFoundException;
    boolean deleteItem(String code) throws SQLException, ClassNotFoundException;
    List<ItemDTO> allItems() throws SQLException, ClassNotFoundException;
}
