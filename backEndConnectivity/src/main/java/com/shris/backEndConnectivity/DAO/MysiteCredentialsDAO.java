package com.shris.backEndConnectivity.DAO;


import java.util.List;
import com.shris.backEndConnectivity.model.MysiteCredentials;

public interface MysiteCredentialsDAO {
	
	
	List<MysiteCredentials> SelectAllSellerCredential();
	MysiteCredentials SelectPassword(String email);
	boolean updatepassword(MysiteCredentials mysitecredential);
	MysiteCredentials SelectOneUser(String email);
}
