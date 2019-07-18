package com.shris.backEndConnectivity.DAOImpl;

import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shris.backEndConnectivity.DAO.OrdersDAO;
import com.shris.backEndConnectivity.model.MyProduct;
import com.shris.backEndConnectivity.model.Orders;


@Repository
@Transactional
public class OrdersDAOImpl implements OrdersDAO {
	
	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public boolean insertOrder(Orders orders) {
		try
		{
			sessionfactory.getCurrentSession().save(orders);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		
	}

	@Override
	public Orders SelectOneOrder(String orderid) {
		try
		{
			return (Orders) sessionfactory.getCurrentSession().createQuery("from Orders where orderId='"+orderid+"'").uniqueResult();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Orders> selectAllOrders(int custid) {
		try
		{
	 List<Orders> orders = sessionfactory.getCurrentSession().createQuery("from Orders where customer = " +custid).list();
	 	return orders;
	 
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	
	}

	@Override
	public List<Orders> selectbySeller(int product) {
		try
		{
		List<Orders> orders	= (List<Orders>) sessionfactory.getCurrentSession().createQuery("from Orders where orderState='Ordered' and product_productid='"+product+"'").list();
			return orders ;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public Orders SelectOneProduct(int pid) {
		try
		{
		Orders oreders =(Orders) sessionfactory.getCurrentSession().createQuery("from Orders where product_productId="+pid).uniqueResult();
		return oreders;
		}catch(Exception e)
		{
			return null;
		}
	}

	@Override
	public boolean updateStatus(Orders oreder) {
		try
		{
			sessionfactory.getCurrentSession().update(oreder);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Orders> selectbyadmin() {
		try
		{
		List<Orders> orders	= (List<Orders>) sessionfactory.getCurrentSession().createQuery("from Orders where orderState='Shipped' ").list();
			return orders ;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
