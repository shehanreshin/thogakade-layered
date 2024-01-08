package dao;

import dao.custom.impl.CustomerDAOImpl;
import dao.custom.impl.ItemDAOImpl;
import dao.custom.impl.OrderDAOImpl;
import dao.custom.impl.OrderDetailDAOImpl;
import dao.util.DAOType;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getInstance(){
        return daoFactory!=null? daoFactory:(daoFactory=new DAOFactory());
    }

    public <T extends SuperDAO>T getDao(DAOType type){
        switch (type){
            case CUSTOMER: return(T) new CustomerDAOImpl();
            case ITEM: return(T) new ItemDAOImpl();
            case ORDER: return(T) new OrderDAOImpl();
            case ORDER_DETAIL: return(T) new OrderDetailDAOImpl();
        }
        return null;
    }
}
