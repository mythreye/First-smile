package com.shris.backEndConnectivity.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.shris.backEndConnectivity.DAO.CartDAO;
import com.shris.backEndConnectivity.model.Cart;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {
	
	@Autowired 
	SessionFactory sessionFactory;

	


	public boolean deleteOneCart(int cartid) {
		try
		{
			sessionFactory.getCurrentSession().delete(SelectOneCart(cartid));
			return true;
			
		}catch (Exception e) {
			System.out.println("insertcart" + e.getMessage());
			return false;
		}
	}
	
	

	

	@Override
	public Cart SelectOneCart(int cartid) {
		try
		{
			Cart cartItem = (Cart) sessionFactory.getCurrentSession().createQuery("from Cart where itemid="+cartid).uniqueResult();
			return cartItem;
			
		}catch (Exception e) {
			System.out.println("insertcart" + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Cart> SelectCart(int custid) {
		try
		{
			ArrayList<Cart> c= (ArrayList<Cart>) sessionFactory.getCurrentSession().createQuery("from Cart where customer="+custid).list();
			if(c.isEmpty())
			{
				return new ArrayList<Cart>();
			}
			else
			{
				return c;
			}
		}catch (Exception e) {
			System.out.println("insertcart" + e.getMessage());
			return new ArrayList<Cart>();
		}
	}

	@Override
	public boolean insertCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().save(cart);
			return true;
			
		}catch (Exception e) {
			System.out.println("insertcart" + e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updatecart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);;
			return true;
			
		}catch (Exception e) {
			System.out.println("insertcart" + e.getMessage());
			return false;
		}
	}





	
	

}
