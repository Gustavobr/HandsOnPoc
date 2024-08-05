package br.com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.poc.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(nativeQuery = true, value = "SELECT MAX(PRICE) FROM PRODUCT P AS MAX_PRICE")
	
	Product findProductMostExpensive();

}
