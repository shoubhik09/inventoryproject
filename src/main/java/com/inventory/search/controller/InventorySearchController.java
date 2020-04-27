package com.inventory.search.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.search.model.Product;
import com.inventory.search.model.ProductRequest;
import com.inventory.search.service.InventorySearchService;

@RestController
public class InventorySearchController {
	
	@Autowired
	private InventorySearchService inventorySearchService;

	@GetMapping("fetch-product/{product-id}")
	public Product fetchProductById(@PathVariable("product-id") int productId, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		System.out.println("fetchProductById");
		System.out.println("fetchProductById test");
		Product myProduct = null;
		try {
			Optional<Product> products = inventorySearchService.serachProductById(productId);
			if(products.isPresent()) {
				myProduct = products.get();
			}
		} catch (Exception e) {
			System.out.println("Error occured while fetchProductById : " + e.getMessage());
		}
		return myProduct;
	}
	
	@GetMapping("fetch-products-by-category/{product-category}")
	public List<Product> fetchProductByCategory(@PathVariable("product-category") String productCategory, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		System.out.println("fetchProductByCategory");
		List<Product> products = null;
		try {
			products = inventorySearchService.serachProductsByCategory(productCategory);
		} catch (Exception e) {
			System.out.println("Error occured while fetchProductByCategory : " + e.getMessage());
		}
		return products;
	}
	
	@GetMapping("fetch-products-by-type/{product-type}")
	public List<Product> fetchProductByType(@PathVariable("product-type") String productType, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		System.out.println("fetchProductByType");
		List<Product> products = null;
		try {
			products = inventorySearchService.serachProductsByType(productType);
		} catch (Exception e) {
			System.out.println("Error occured while fetchProductByType : " + e.getMessage());
		}
		return products;
	}
	
	@PostMapping("addProduct")
	public String addProduct( HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody Product product) {
		System.out.println("addProduct");
		String message = "Error occured while adding the product.";
		try {
			Product savedProduct = inventorySearchService.addProduct(product);
			if(savedProduct != null) {
				message = "Product added successfully.";
			}
		} catch (Exception e) {
			System.out.println("Error occured while addProduct : " + e.getMessage());
		}
		return message;
	}
	
	@PostMapping("advanced-search")
	public List<Product> fetchProductByAdvancedSearch(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, 
			@RequestBody ProductRequest productRequest) {
		System.out.println("fetchProductByAdvancedSearch");
		List<Product> products = null;
		try {
			products = inventorySearchService.advancedSearch(productRequest);
		} catch (Exception e) {
			System.out.println("Error occured while fetchProductByAdvancedSearch : " + e.getMessage());
		}
		return products;
	}
}
