package com.shris.backEndConnectivity.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shris.backEndConnectivity.DAO.MyProductDAO;
import com.shris.backEndConnectivity.model.MyProduct;


@Repository
@Transactional
public class MyProductDAOImpl implements MyProductDAO {
	
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean insertProduct(MyProduct product) {
		try {
		sessionfactory.getCurrentSession().save(product);
		return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteProduct(int id) {
		try {
			sessionfactory.getCurrentSession().delete(SelectOneProduct(id));
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		return false;
		}
	}

	@Override
	public boolean updateProduct(MyProduct product) {
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		return false;
		}
	}

	@Override
	public MyProduct SelectOneProduct(int id) {
		try{
		    
			MyProduct myproduct =(MyProduct) sessionfactory.getCurrentSession().createQuery("from MyProduct   where PRODUCTID = "+id).uniqueResult();
				return myproduct;
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
	}

	@Override
	public List<MyProduct> SelectAllProduct(int id) {
		try
		{
			
			List<MyProduct> listproduct = (List<MyProduct>) sessionfactory.getCurrentSession().createQuery("from MyProduct where myseller_sellerid="+id).list();
			return listproduct;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<MyProduct> SelectAllProductUser() {
		try
		{
			
			List<MyProduct> listproduct = (List<MyProduct>) sessionfactory.getCurrentSession().createQuery("from MyProduct").list();
			return listproduct;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	@Override
	public List<MyProduct> SelectbySeller(int sellerid) {
		try
		{
		List<MyProduct> product	 =sessionfactory.getCurrentSession().createQuery("from MyProduct where myseller_sellerid="+sellerid).list();
		return product;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<MyProduct> SelectbyCategory(int cateid) {
		try
		{
		List<MyProduct> product	 =sessionfactory.getCurrentSession().createQuery("from MyProduct where mycategory_categoryid="+cateid).list();
		return 	product;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
