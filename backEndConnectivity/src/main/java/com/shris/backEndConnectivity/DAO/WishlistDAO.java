package com.shris.backEndConnectivity.DAO;

import java.util.List;

import com.shris.backEndConnectivity.model.Wishlist;

public interface WishlistDAO {
	
	boolean insertWishlist(Wishlist wishlist);
	boolean deleteWishlist(int id);
	Wishlist selectone(int wishid);
	List<Wishlist> selectWishList(int custid);
	

}
