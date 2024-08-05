package br.com.poc.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.poc.entity.Product;
import br.com.poc.repository.ProductRepository;
import br.com.poc.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/product")
@RestController
@EnableSpringDataWebSupport
@EntityScan(basePackageClasses = br.com.poc.entity.Product.class)
public class ProductController {

	@Autowired

	private ProductService service;

	@Autowired

	private ProductRepository repository;
	
	
	private final RabbitTemplate rabbitTemplate = new RabbitTemplate();

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@CacheEvict(allEntries = true)
	@Transactional(readOnly = true)
	@Operation(summary = "Retrieve all products")
	public java.util.List<Product> retrieveAllProducts(@PageableDefault(size = 10) Pageable paginacao) {
		return repository.findAll().stream().filter(p -> p.getQuantity() >= 1).toList();

		// return repository.findAll();
	}

	@GetMapping("/{id}")
	@Transactional
	@Operation(summary = "Retrieve product by id")
	public ResponseEntity<Product> retrieveProductById(@PathVariable(required = true, name = "id") Long id)
			throws Exception {
		Product product = repository.findById(id).get();
		if (product.equals(service.findProductById(id))) {
			return ResponseEntity.ok(product);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
