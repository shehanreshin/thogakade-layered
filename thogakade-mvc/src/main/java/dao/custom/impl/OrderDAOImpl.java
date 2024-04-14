package dao.custom.impl;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import dao.util.CrudUtil;
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
        String sql = "INSERT INTO orders VALUES(?,?,?)";
        if (CrudUtil.execute(sql, entity.getOrderId(), entity.getDate(), entity.getCustId())) {
            boolean isDetailsSaved = orderDetailDAO.saveOrderDetails(entity.getList());
            if (isDetailsSaved) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getLastOrderId() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM orders ORDER BY id DESC LIMIT 1");
        if (!resultSet.next()) return "D001";
        return resultSet.getString(1);
    }
}
