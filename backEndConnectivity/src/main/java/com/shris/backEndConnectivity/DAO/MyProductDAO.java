package com.shris.backEndConnectivity.DAO;

import java.util.List;


import com.shris.backEndConnectivity.model.MyProduct;

public interface MyProductDAO {
	
	boolean insertProduct(MyProduct product);
	boolean updateProduct(MyProduct product);
	boolean deleteProduct(int id);
	
	MyProduct SelectOneProduct(int id);
	List<MyProduct> SelectAllProduct(int id);
	List<MyProduct> SelectAllProductUser();
	List<MyProduct> SelectbySeller(int sellerid);
	List<MyProduct> SelectbyCategory(int cateid);
}
