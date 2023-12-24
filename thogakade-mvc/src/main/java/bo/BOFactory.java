package bo;

import bo.custom.impl.CustomerBOImpl;
import bo.custom.impl.ItemBOImpl;
import bo.custom.impl.OrderDetailBOImpl;
import bo.custom.impl.OrdersBOImpl;
import dao.custom.impl.CustomerDAOImpl;
import dao.util.BOType;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        return boFactory == null ? (boFactory = new BOFactory()) : boFactory;
    }

    public <T extends SuperBO>T getBo(BOType boType) {
        switch (boType) {
            case CUSTOMER: return (T) new CustomerBOImpl();
            case ITEM: return (T) new ItemBOImpl();
            case ORDER: return (T) new OrdersBOImpl();
            case ORDER_DETAIL: return (T) new OrderDetailBOImpl();
        }
        return null;
    }
}
