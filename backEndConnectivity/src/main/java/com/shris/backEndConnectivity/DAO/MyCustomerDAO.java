package com.shris.backEndConnectivity.DAO;

import java.util.List;


import com.shris.backEndConnectivity.model.MyCustomer;

public interface MyCustomerDAO {

	boolean insertCustomer(MyCustomer mycustomer);
	boolean updateCustomer(MyCustomer mycustomer);
	boolean verifyemail(String email);
	MyCustomer SelectOneCustomer(String emailid);
	List<MyCustomer> SelectAllCustomer();
	
}
