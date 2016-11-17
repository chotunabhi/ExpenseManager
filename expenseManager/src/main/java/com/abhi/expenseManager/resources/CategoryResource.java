package com.abhi.expenseManager.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.abhi.expenseManager.objectModels.Category;
import com.abhi.expenseManager.services.CategoryService;

@Path("categories")
public class CategoryResource {
	CategoryService categoryService = CategoryService.getInstance();
	
	@GET
	public List<Category> getCategories(){
		return categoryService.getCategories();
	}
}
