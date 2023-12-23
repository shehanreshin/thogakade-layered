package dao.custom;

import dto.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO {
    boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
    OrderDTO getLastOrder() throws SQLException, ClassNotFoundException;
}
