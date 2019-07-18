package com.shris.backEndConnectivity.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shris.backEndConnectivity.DAO.MyCustomerDAO;
import com.shris.backEndConnectivity.model.MyCustomer;
import com.shris.backEndConnectivity.model.MysiteCredentials;


@Repository
@Transactional
public class MyCustomerDAOImpl implements MyCustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean insertCustomer(MyCustomer mycustomer) {
		try {
			sessionFactory.getCurrentSession().save(mycustomer);
			MysiteCredentials mysiteCredentials = new MysiteCredentials();
			mysiteCredentials.setCredentialemail(mycustomer.getCustomeremail());
			mysiteCredentials.setCredentialpassword(mycustomer.getCustomerpassword());
			mysiteCredentials.setCredentialrole("ROLE_USER");
			mysiteCredentials.setCredentialstatus(false);
			sessionFactory.getCurrentSession().save(mysiteCredentials);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateCustomer(MyCustomer mycustomer) {
		try {
			sessionFactory.getCurrentSession().update(mycustomer);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public MyCustomer SelectOneCustomer(String emailid) {
		try {

			MyCustomer mycustomer = (MyCustomer) sessionFactory.getCurrentSession()
					.createQuery("from MyCustomer where customeremail='"+emailid+"'").uniqueResult();
			return mycustomer;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public List<MyCustomer> SelectAllCustomer() {

		try {

			List<MyCustomer> listcustomer = (List<MyCustomer>) sessionFactory.getCurrentSession()
					.createQuery("from MyCustomer ").list();
			return listcustomer;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public boolean verifyemail(String email) {
		MysiteCredentials credentials = (MysiteCredentials) sessionFactory.getCurrentSession()
				.createQuery("from MysiteCredentials where credentialemail='" + email + "'").uniqueResult();
		if (credentials.isCredentialstatus()) {
			return false;
		} else {
			credentials.setCredentialstatus(true);
			sessionFactory.getCurrentSession().update(credentials);
			return true;
		}
	}

}
