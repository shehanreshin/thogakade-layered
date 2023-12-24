package dao.custom;

import dao.CrudDAO;
import dto.OrderDetailDTO;
import entity.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDAO {
    OrderDetailDTO searchOrder(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException;
    boolean saveOrderDetails(List<OrderDetailDTO> list) throws SQLException, ClassNotFoundException;
    List<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException;
}
