package dao.custom.impl;

import db.DBConnection;
import dto.OrderDTO;
import dao.custom.OrderDetailDAO;
import dao.custom.OrderDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAOImpl implements OrderDAO {
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();
    @Override
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO orders VALUES(?,?,?)");
        pstm.setString(1, orderDTO.getOrderId());
        pstm.setString(2, orderDTO.getDate());
        pstm.setString(3, orderDTO.getCustId());

        if (pstm.executeUpdate() > 0) {

            boolean isDetailsSaved = orderDetailDAO.saveOrderDetails(orderDTO.getList());
            if (isDetailsSaved) {
                return true;
            }
        }
        return false;
    }

    @Override
    public OrderDTO getLastOrder() throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM orders ORDER BY id DESC LIMIT 1");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            return new OrderDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    null
            );
        }
        return null;
    }
}
