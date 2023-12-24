package dao.custom;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import dao.CrudDAO;
import dto.OrderDTO;
import entity.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    boolean saveOrderDetails(OrderDTO dto) throws SQLException, ClassNotFoundException;
    OrderDTO getLastOrder() throws SQLException, ClassNotFoundException;
}
