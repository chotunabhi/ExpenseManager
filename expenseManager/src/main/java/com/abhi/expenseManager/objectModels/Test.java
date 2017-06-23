package com.abhi.expenseManager.objectModels;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="test")
public class Test<T> {
	private int count = 0;
	List<T> userNames = new ArrayList<>(3);
	
	public Test(){
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getUserNames() {
		return userNames;
	}

	public void setUserNames(List<T> userNames) {
		this.userNames.addAll(userNames);
	}
	
	
}
