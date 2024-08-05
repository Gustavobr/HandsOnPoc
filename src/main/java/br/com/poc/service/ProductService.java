package br.com.poc.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.poc.entity.Product;
import br.com.poc.repository.ProductRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
@ComponentScan(basePackageClasses = br.com.poc.configuration.Configuration.class)
public class ProductService {

	@Autowired

	private ProductRepository repository;

	@Autowired

	private ModelMapper mapper;
	
	
	private Page<Product> findAll(Pageable paginacao){
		return repository.findAll(paginacao);
	}

	public void addProduct(Product product) throws JsonProcessingException {
		try {
			Optional<Product> prod = repository.findById(product.getId());
			if (prod == null) {
				repository.save(product);
			} else {
				repository.saveAndFlush(product);
			}
		} catch (Exception ex) {
		}
	}

	public void removeProduct(Long id) throws EntityNotFoundException, Exception {
		if (id != null) {
			Product product = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
			repository.delete(product);
		}
	}

	public Product updateProduct(Long id, Product product) throws EntityExistsException, Exception {
		Optional<Product> prod = repository.findById(id);
		if (prod.isPresent()) {
			Product produto = new Product();
			produto.setId(prod.get().getId());
			produto.setDescription(product.getDescription());
			produto.setPrice(product.getPrice());
			produto.setQuantity(product.getQuantity());
			produto.setStore(product.getStore());

			return produto;
		}
		return product;
	}

	public Product findProductById(Long id) throws EntityNotFoundException, Exception {
		if (id != null) {
			Product prod = repository.findById(id).get();
			if (prod != null) {
				return prod;
			} else {
				return new Product(null, 0, null);
			}
		}
		return null;
	}
}
