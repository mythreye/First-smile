package com.shris.backEndConnectivity.DAO;

import com.shris.backEndConnectivity.model.ChangePassword;

public interface ChangePasswordDAO {
	
	ChangePassword checkoldpassword(String email);
	boolean updatenewpassword(ChangePassword changepwd);
	ChangePassword chnpwd(String email);
}
