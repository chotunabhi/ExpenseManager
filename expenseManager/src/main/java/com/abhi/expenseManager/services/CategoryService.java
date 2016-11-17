package com.abhi.expenseManager.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.abhi.expenseManager.objectModels.Category;

public class CategoryService {
	private static CategoryService categoryService = null;
	
	private CategoryService(){
/*		Category parentCategory1 = new Category();
		parentCategory1.setCategoryName("Pcat1");
		
		Category parentCategory2 = new Category();
		parentCategory2.setCategoryName("Pcat2");
		
		Category childCategory1 = new Category();
		childCategory1.setCategoryName("Ccat1");
		childCategory1.setParentCategory(parentCategory1);

		Category childCategory2 = new Category();
		childCategory2.setCategoryName("Ccat2");
		childCategory2.setParentCategory(parentCategory1);

		Category childCategory3 = new Category();
		childCategory3.setCategoryName("Ccat3");
		childCategory3.setParentCategory(parentCategory2);

		Session session = PersistantFactory.getSession();
		session.beginTransaction();
		session.saveOrUpdate(parentCategory1);
		session.saveOrUpdate(parentCategory2);
		session.saveOrUpdate(childCategory1);
		session.saveOrUpdate(childCategory2);
		session.saveOrUpdate(childCategory3);
		session.getTransaction().commit();
		session.close();
*/	}
	
	public static CategoryService getInstance(){
		if(categoryService == null)
			categoryService = new CategoryService();
		
		return categoryService;
	}

	public List<Category> getCategories() {
		Session session = PersistantFactory.getSession();
		session.beginTransaction();
		
		Query query = (Query) session.createQuery("select distinct e from categories e where e.categoryLevel = ?");
		query.setInteger(0, 0);
		
		List<Category> categories = query.list();//criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return categories;
	}
	
}
