package bo.custom;

import dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBO<T> {
    boolean saveCustomer(T dto) throws SQLException, ClassNotFoundException;
    boolean updateCustomer(T dto) throws SQLException, ClassNotFoundException;
    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    List<CustomerDTO> allCustomers() throws SQLException, ClassNotFoundException;
}
