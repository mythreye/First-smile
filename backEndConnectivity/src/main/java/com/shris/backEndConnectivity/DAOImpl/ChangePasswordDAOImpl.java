package com.shris.backEndConnectivity.DAOImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shris.backEndConnectivity.DAO.ChangePasswordDAO;
import com.shris.backEndConnectivity.model.ChangePassword;

@Repository
@Transactional
public class ChangePasswordDAOImpl implements ChangePasswordDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public ChangePassword checkoldpassword(String email) {
		try {
		ChangePassword changepwd = (ChangePassword) sessionFactory.getCurrentSession().createQuery("from MysiteCredentials where credentialemail='"+email+"' ")
		.uniqueResult();
		return changepwd;
		
		}catch(Exception e) {
			System.out.println("Error in select query"+e.getMessage());
		return null;
		}
	}

	@Override
	public boolean updatenewpassword(ChangePassword changepwd) 
	{
		try {
			sessionFactory.getCurrentSession().update(changepwd);
			return true;
			
			}catch(Exception e) {
				System.out.println("Error in update query"+e.getMessage());
			return false;
			}
	}

	@Override
	public ChangePassword chnpwd(String email) {
		try
		{
			ChangePassword changepwd = (ChangePassword) sessionFactory.getCurrentSession().createQuery("from MysiteCredentials where credentialemail='"+email+"'").uniqueResult();
					return changepwd;
		}catch(Exception e)
		{System.out.println(e.getMessage());
		return null;
		}
	}

}
