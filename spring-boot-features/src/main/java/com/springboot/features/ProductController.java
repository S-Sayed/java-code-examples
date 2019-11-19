package com.springboot.features;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springboot.features.exceptions.ProductNotFoundException;
import com.springboot.features.model.Product;
import com.springboot.features.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	private static final Log log = LogFactory.getLog(ProductController.class);

	@Autowired
	private ProductService productService;

	@GetMapping
	@CrossOrigin // (origins = "http://localhost:4200")
	@HystrixCommand(fallbackMethod = "getProductsFallback", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public ResponseEntity<Object> getProducts() {
		// Thread.sleep(3000); // to check the hystrix functionality
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	}

	public String getProductsFallback() {
		return "Welcome to Hystrix";
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {

		if (!(productService.isProductFound(id))) {
			log.warn("product not found");
			throw new ProductNotFoundException();
		}

		productService.updateProduct(product);
		return new ResponseEntity<>("product updated successfully", HttpStatus.OK);
	}

}
