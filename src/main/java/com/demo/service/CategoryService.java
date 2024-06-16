package com.demo.service;

public interface CategoryService {

	// create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	CategoryDto updateCategory(CategoryDto categoryDto,int categoryId);
	
	// delete
	void deleteCategory(int categoryId);
	
	// get
	CategoryDto getCategory(int categoryId);
	
	// get All
	List<CategoryDto> getCategories();
}