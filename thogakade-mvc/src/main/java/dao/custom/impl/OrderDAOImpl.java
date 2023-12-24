package dao.custom.impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import db.DBConnection;
import dto.OrderDTO;
import dao.custom.OrderDetailDAO;
import dao.custom.OrderDAO;
import entity.Orders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAOImpl();

    @Override
    public boolean saveOrderDetails(OrderDTO entity) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO orders VALUES(?,?,?)");
        pstm.setString(1, entity.getOrderId());
        pstm.setString(2, entity.getDate());
        pstm.setString(3, entity.getCustId());

        if (pstm.executeUpdate() > 0) {

            boolean isDetailsSaved = orderDetailDAO.saveOrderDetails(entity.getList());
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
