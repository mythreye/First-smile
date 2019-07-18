package com.shris.backEndConnectivity.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shris.backEndConnectivity.DAO.MySellerDAO;
import com.shris.backEndConnectivity.model.MyCategory;
import com.shris.backEndConnectivity.model.MySeller;
import com.shris.backEndConnectivity.model.MysiteCredentials;

@Repository
@Transactional
public class MySellerDAOImpl implements MySellerDAO {
	
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean insertSeller(MySeller myseller) {
	try {
		
		sessionfactory.getCurrentSession().save(myseller);
		MysiteCredentials mysiteCredentials = new MysiteCredentials();
		mysiteCredentials.setCredentialemail(myseller.getSelleremail());
		mysiteCredentials.setCredentialpassword(myseller.getSellerpassword());
		mysiteCredentials.setCredentialrole("ROLE_SELLER");
		mysiteCredentials.setCredentialstatus(false);
		sessionfactory.getCurrentSession().save(mysiteCredentials);
		return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateSeller(MySeller myseller) {
		try {
			sessionfactory.getCurrentSession().update(myseller);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		return false;
		}
	}

	@Override
	public boolean deleteSeller(int id) {
		try {
			MySeller myseller =(MySeller) sessionfactory.getCurrentSession().createQuery("from MySeller  where sellerid = "+id).uniqueResult();
			sessionfactory.getCurrentSession().delete(myseller);
			MysiteCredentials mysitecredentails	= (MysiteCredentials) sessionfactory.getCurrentSession().createQuery("from MysiteCredentials where credentialemail='"+myseller.getSelleremail()+"'").uniqueResult();
			sessionfactory.getCurrentSession().delete(mysitecredentails);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		return false;
		}
	}

	@Override
	public MySeller SelectOneSeller(String email) {
		try{
		    
			MySeller myseller =(MySeller) sessionfactory.getCurrentSession().createQuery("from MySeller where selleremail = '"+email+"'").uniqueResult();
				return myseller;
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
	}

	@Override
	public List<MySeller> SelectAllSeller() {
		try
		{
			
			List<MySeller> listseller = (List<MySeller>) sessionfactory.getCurrentSession().createQuery("from MySeller").list();
			return listseller;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean updateStatus(String email) {
		
		try
		{
		MysiteCredentials mysitecredentails	= (MysiteCredentials) sessionfactory.getCurrentSession().createQuery("from MysiteCredentials where credentialemail='"+email+"'").uniqueResult();
		mysitecredentails.setCredentialstatus(true);
		sessionfactory.getCurrentSession().update(mysitecredentails);
		return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	@Override
	public MySeller SelectOneSellerID(int sellerid) {
		try
		{
			MySeller myseller =(MySeller) sessionfactory.getCurrentSession().createQuery("from MySeller where sellerid = '"+sellerid+"'").uniqueResult();
			return myseller;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	

	

}
