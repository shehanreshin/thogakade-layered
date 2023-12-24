package dao.custom.impl;

import db.DBConnection;
import dto.OrderDetailDTO;
import dao.custom.OrderDetailDAO;
import entity.Item;
import entity.OrderDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {
    @Override
    public OrderDetailDTO searchOrder(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveOrderDetails(List<OrderDetailDTO> list) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO order_detail VALUES(?,?,?,?)");

        for (OrderDetailDTO orderDetailDTO : list) {
            preparedStatement.setString(1,orderDetailDTO.getOrderId());
            preparedStatement.setString(2,orderDetailDTO.getItemCode());
            preparedStatement.setInt(3,orderDetailDTO.getQty());
            preparedStatement.setDouble(4,orderDetailDTO.getUnitPrice());
            if (!(preparedStatement.executeUpdate()>0)){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        PreparedStatement preparedStatement = DBConnection.getInstance().getConnection().prepareStatement("SELECT * FROM order_detail");
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            orderDetailDTOList.add(new OrderDetailDTO(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4)
            ));
        }

        return orderDetailDTOList;
    }


}
