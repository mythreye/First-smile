package com.shris.backEndConnectivity.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shris.backEndConnectivity.DAO.WishlistDAO;
import com.shris.backEndConnectivity.model.MySeller;
import com.shris.backEndConnectivity.model.Wishlist;


@Repository
@Transactional
public class WishlistDAOImpl implements WishlistDAO {
	
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean insertWishlist(Wishlist wishlist) {
		try
		{
			sessionfactory.getCurrentSession().save(wishlist);
			return true;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteWishlist(int id) {
		try
		{
			sessionfactory.getCurrentSession().delete(selectone(id));
			return true;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Wishlist> selectWishList(int custid) {
		try
		{
		List<Wishlist>	wishlist = (List<Wishlist>) sessionfactory.getCurrentSession().createQuery("from Wishlist where customerid="+custid).list();
			return  wishlist;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Wishlist selectone(int wishid) {
		try
		{
			Wishlist wishlist= (Wishlist) sessionfactory.getCurrentSession().createQuery("from Wishlist where wishlistid="+wishid).uniqueResult();
			
			return wishlist;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
