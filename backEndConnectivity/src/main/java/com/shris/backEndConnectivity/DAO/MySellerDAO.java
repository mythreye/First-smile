package com.shris.backEndConnectivity.DAO;

import java.util.List;

import com.shris.backEndConnectivity.model.MySeller;



public interface MySellerDAO {
	
	boolean insertSeller(MySeller myseller);
	boolean updateSeller(MySeller myseller);
	boolean deleteSeller(int id);
	MySeller SelectOneSeller(String email);
	MySeller SelectOneSellerID(int sellerid);
	List<MySeller> SelectAllSeller();
	boolean updateStatus(String email);
	

}
