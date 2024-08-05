package br.com.poc.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_STORE")
@Getter
@Setter
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Store {

	public Store() {

	}

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column
	@NotNull(message = "please insert a name.")
	@NotBlank(message = "please do not leave blank.")
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "store", targetEntity = br.com.poc.entity.Product.class, fetch = FetchType.EAGER)
	private java.util.List<Product> produtos = new ArrayList<>();

	@Column(updatable = true, insertable = true)
	private int capacity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Store(
			@NotNull(message = "please insert a name.") @NotBlank(message = "please do not leave blank.") String name,
			int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

}
