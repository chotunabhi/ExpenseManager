package com.abhi.expenseManager.objectModels;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name="categories")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int categoryId;
	@Column(name="category_name")
	private String categoryName;
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name="parent_category_id")
	private Category parentCategory;
	@OneToMany(mappedBy="parentCategory",fetch=FetchType.EAGER)
	private List<Category> childCategories;
	@Column(name = "category_level")
	private int categoryLevel;
	
	public int getCategoryLevel() {
		return categoryLevel;
	}
	public void setCategoryLevel(int categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
	public List<Category> getChildCategories() {
		return childCategories;
	}
	public void setChildCategories(List<Category> childCategories) {
		this.childCategories = childCategories;
	}
	@XmlTransient
	public Category getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
