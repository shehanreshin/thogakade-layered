package bo.custom;

import bo.SuperBO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrdersBO extends SuperBO {
    boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateOrder(OrderDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteOrder(String id) throws SQLException, ClassNotFoundException;
    List<OrderDetailDTO> allOrders() throws SQLException, ClassNotFoundException;
}
