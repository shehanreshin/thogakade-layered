package dao.custom.impl;

import dao.util.CrudUtil;
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
        String sql = "INSERT INTO order_detail VALUES(?,?,?,?)";

        for (OrderDetailDTO orderDetailDTO : list) {
            boolean isSaved = CrudUtil.execute(sql, orderDetailDTO.getOrderId(), orderDetailDTO.getItemCode(), orderDetailDTO.getQty(), orderDetailDTO.getUnitPrice());
            if (!isSaved){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {
        List<OrderDetailDTO> orderDetailDTOList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM order_detail");

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
