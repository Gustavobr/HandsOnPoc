package br.com.poc.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.poc.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class ProductDTO implements Serializable {

	/**
	 * 
	 */
	
	public ProductDTO() {
		super();
	}
	
	private static final long serialVersionUID = 1L;

	private BigDecimal price;

	private int quantity;

	private Long id;

	private Product product;

	private String description;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
