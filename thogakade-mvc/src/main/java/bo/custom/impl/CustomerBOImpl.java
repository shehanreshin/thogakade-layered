package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.custom.CustomerDAO;
import dao.custom.impl.CustomerDAOImpl;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerBOImpl implements CustomerBO {

    private CustomerDAO customerDAO = new CustomerDAOImpl();

    @Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return  customerDAO.update(new Customer(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getSalary()
        ));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public List<CustomerDTO> allCustomers() throws SQLException, ClassNotFoundException {
        List<Customer> entityList = customerDAO.getAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer:entityList) {
            customerDTOList.add(new CustomerDTO(
                    customer.getId(),
                    customer.getName(),
                    customer.getAddress(),
                    customer.getSalary()
            ));
        }
        return customerDTOList;
    }
}
