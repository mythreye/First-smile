package com.shris.backEndConnectivity.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shris.backEndConnectivity.DAO.AddressDAO;
import com.shris.backEndConnectivity.model.Address;

@Repository
@Transactional

public class AddressDAOImpl implements AddressDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean insertAddress(Address address) {
		try
		{
			sessionFactory.getCurrentSession().save(address);
			return true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try
		{
			sessionFactory.getCurrentSession().update(address);
			return true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteOneAddress(int addressid) {
		try
		{
			sessionFactory.getCurrentSession().delete(SelectOneAddress(addressid));
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public Address SelectOneAddress(int addressid) {
		try
		{
		
		return (Address)sessionFactory.getCurrentSession().createQuery("from Address where addressid="+addressid).uniqueResult();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Address> SelectAddress(int custid) {
		try
		{
			ArrayList<Address> addressObj = (ArrayList<Address>) sessionFactory.getCurrentSession().createQuery("from Address where mycustomer="+custid).list();
			return addressObj;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}

}
