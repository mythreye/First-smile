package com.shris.backEndConnectivity.DAO;

import java.util.List;

import com.shris.backEndConnectivity.model.MyProduct;
import com.shris.backEndConnectivity.model.Orders;

public interface OrdersDAO {
	
	boolean insertOrder(Orders orders);
	Orders SelectOneOrder(String orderid);
	List<Orders> selectAllOrders(int custid);
	List<Orders> selectbySeller(int product);
	Orders SelectOneProduct(int pid);
	boolean updateStatus(Orders oreder);
	List<Orders> selectbyadmin();

}
