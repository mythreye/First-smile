package com.shris.backEndConnectivity.DAO;

import java.util.List;

import com.shris.backEndConnectivity.model.Cart;

public interface CartDAO {
	
	boolean insertCart(Cart cart);
	boolean updatecart(Cart cart);
	boolean deleteOneCart(int itemid);
	Cart SelectOneCart(int itemid);
	
	List<Cart> SelectCart(int custid);

}
