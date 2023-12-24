package bo.custom.impl;

import bo.custom.OrdersBO;
import dao.custom.OrderDAO;
import dao.custom.OrderDetailDAO;
import dao.custom.impl.OrderDAOImpl;
import dao.custom.impl.OrderDetailDAOImpl;
import dto.OrderDTO;
import dto.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public class OrdersBOImpl implements OrdersBO<OrderDTO> {
    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    @Override
    public boolean saveOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return orderDAO.saveOrderDetails(dto);
    }

    @Override
    public boolean updateOrder(OrderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteOrder(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<OrderDetailDTO> allOrders() throws SQLException, ClassNotFoundException {
        return orderDetailDAO.getAll();
    }
}
