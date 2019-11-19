package com.springboot.features.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.features.model.Product;

@Service
public class ProductService {

	private static List<Product> products = new ArrayList<>();

	// static data for testing, in real application, should use DB
	static {
		products.add(new Product(1, "TEA"));
		products.add(new Product(2, "COFFE"));
		products.add(new Product(3, "MILK"));
	}

	public List<Product> getProducts() {
		return products;
	}

	public boolean isProductFound(long id) {
		return products.stream().anyMatch(e -> e.getId() == id);
	}

	public void updateProduct(Product product) {
		Iterator<Product> prodIterator = products.iterator();
		Product productToBeUpdated = null;

		while (prodIterator.hasNext()) {
			productToBeUpdated = prodIterator.next();

			if (productToBeUpdated.getId() == product.getId()) {
				products.remove(productToBeUpdated);
				products.add(product);
				break;
			}
		}

	}
}
