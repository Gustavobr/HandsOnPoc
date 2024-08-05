package br.com.poc.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_PRODUCT")
@Data
@Setter
@Getter
//@AllArgsConstructor
//@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

	public Product() {
		super();
	}

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(unique = true)
	@NotEmpty(message = "Please do not leave blank.")
	@NotNull(message = "Please insert a description")
	private String description;

	@Column(nullable = true)
	private int quantity;

	@Column(updatable = true, insertable = true)
	private BigDecimal price;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", name = "fk_store_id")

	@JsonBackReference
	private Store store;

	public Product(
			@NotEmpty(message = "Please do not leave blank.") @NotNull(message = "Please insert a description") String description,
			int quantity, BigDecimal price) {
		super();
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

}
