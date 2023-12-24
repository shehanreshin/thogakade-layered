package bo.custom;

import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrdersBO<T> {
    boolean saveOrder(T dto) throws SQLException, ClassNotFoundException;
    boolean updateOrder(T dto) throws SQLException, ClassNotFoundException;
    boolean deleteOrder(String id) throws SQLException, ClassNotFoundException;
    List<OrderDetailDTO> allOrders() throws SQLException, ClassNotFoundException;
}
