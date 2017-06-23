package com.abhi.expenseManager;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.abhi.expenseManager.resources.AccountResource;
import com.abhi.expenseManager.resources.CategoryResource;
import com.abhi.expenseManager.resources.IncomeSourceResource;
import com.abhi.expenseManager.resources.TransactionResource;
import com.abhi.expenseManager.resources.UserResource;

@ApplicationPath("webapi")
public class BootStrap extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>(5);
        classes.add(AccountResource.class);
        classes.add(CategoryResource.class);
        classes.add(IncomeSourceResource.class);
        classes.add(TransactionResource.class);
        classes.add(UserResource.class);
        
		return Collections.emptySet();
    }

}
