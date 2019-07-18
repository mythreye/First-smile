package com.shris.backEndConnectivity.DAOImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shris.backEndConnectivity.DAO.MyCategoryDAO;
import com.shris.backEndConnectivity.model.MyCategory;



@Repository
@Transactional
public class MyCategoryDAOImpl implements MyCategoryDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;

	
	public boolean insertCategory(MyCategory mycategory) 
	{
		try {
			sessionFactory.getCurrentSession().save(mycategory);
		return true;
		}
		catch (Exception e) {
			System.out.println("Error in insert Query"+e.getMessage());
			return false;
		}
	}

	
	public boolean deleteCategry(int categoryid) {
		try {
			sessionFactory.getCurrentSession().delete(SelectOneCategory(categoryid));
			return true;
		}catch(Exception e)
		{
			System.out.println("Not Deleted"+e.getMessage());
		return false;
		}
	}


	public boolean updateCategory(MyCategory mycategory) {
		try
		{
			sessionFactory.getCurrentSession().update(mycategory);
			return true;
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		return false;
		}
	}


	public MyCategory  SelectOneCategory(int cid) {
		try {
			MyCategory mycategory =(MyCategory) sessionFactory.getCurrentSession().createQuery("from MyCategory where categoryid="+cid).uniqueResult();
			return mycategory;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		return null;
		}
	}



	@Override
	public List<MyCategory> SelectAllCateogory() {
		try
		{
			List<MyCategory> listcategory = (List<MyCategory>) sessionFactory.getCurrentSession().createQuery("from MyCategory").list();
			return listcategory;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	

}
