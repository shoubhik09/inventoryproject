package com.inventory.search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventory.search.model.Product;

@Repository
public interface InventorySearchRepository extends CrudRepository<Product, Integer>{
	
	public List<Product> getByProductCategory(String productCategory);
	
	public List<Product> getByProductType(String productType);
	
	@Query("SELECT p FROM Product p WHERE p.productType = ?1 and p.productCategory = ?2 and p.productPrice = ?3 and p.productBrand = ?4")
    public List<Product> advancedSearch(String productType, String productCategory, double productPrice, String productBrand);

}
