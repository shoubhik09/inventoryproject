package com.inventory.search.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.search.model.Product;
import com.inventory.search.model.ProductRequest;
import com.inventory.search.repository.InventorySearchRepository;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class InventorySearchService {
	
	@Autowired
	private InventorySearchRepository inventorySearchRepository;
	
	public Optional<Product> serachProductById(int productId) { 
		return inventorySearchRepository.findById(productId);
	}
	
	@Cacheable("products")
	public List<Product> serachProductsByCategory(String productCategory) { 
		return inventorySearchRepository.getByProductCategory(productCategory);
	}
	
	public List<Product> serachProductsByType(String productType) { 
		return inventorySearchRepository.getByProductType(productType);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	@CacheEvict("products")
	public Product addProduct(Product product) { 
		 return inventorySearchRepository.save(product);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public Iterable<Product> addMultipleProducts(List<Product> products) { 
		 return inventorySearchRepository.saveAll(products);
	}
	
	public List<Product> advancedSearch(ProductRequest productRequest) { 
		return inventorySearchRepository.advancedSearch(productRequest.getProductType(), productRequest.getProductCategory(),
				productRequest.getProductPrice(), productRequest.getProductBrand());
	}

}
