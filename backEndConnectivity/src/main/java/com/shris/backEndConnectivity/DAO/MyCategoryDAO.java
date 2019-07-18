package com.shris.backEndConnectivity.DAO;

import java.util.List;

import com.shris.backEndConnectivity.model.MyCategory;

//import antlr.collections.List;

public interface MyCategoryDAO 
{

	boolean insertCategory(MyCategory mycategory);
	boolean updateCategory(MyCategory mycategory);
	boolean deleteCategry(int categoryid);
	MyCategory SelectOneCategory(int id);
	List<MyCategory> SelectAllCateogory();
}
