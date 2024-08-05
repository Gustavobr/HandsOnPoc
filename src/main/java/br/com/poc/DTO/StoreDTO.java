package br.com.poc.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
//@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO implements Serializable {

	/**
	 * 
	 */

	

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

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

}
