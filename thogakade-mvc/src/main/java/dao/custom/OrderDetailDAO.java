package dao.custom;

import dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    List<OrderDetailDTO> allOrders() throws SQLException, ClassNotFoundException;
    OrderDetailDTO searchOrder(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;
    boolean saveOrderDetails(List<OrderDetailDTO> list) throws SQLException, ClassNotFoundException;
}
