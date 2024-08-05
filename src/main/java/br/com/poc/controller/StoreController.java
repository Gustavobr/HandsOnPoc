package br.com.poc.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.poc.entity.Store;
import br.com.poc.repository.StoreRepository;
import br.com.poc.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.Cacheable;

@RequestMapping("/store")
@RestController
@Cacheable(value = true)
public class StoreController {

	@Autowired

	private StoreService service;

	@Autowired
	private ModelMapper mapper;

	@Autowired

	private StoreRepository repository;

	@GetMapping
	@CacheEvict(allEntries = true)
	@Operation(summary = "Retrieve all stores")
	public Page<Store> retrieveAll(@PageableDefault(size = 10) Pageable paginacao) throws Exception {
		return service.obterTodos(paginacao);

	}

	@DeleteMapping("/{id}")
	@Transactional
	@Operation(summary = "Delete a Store by Id.")
	public ResponseEntity<Store> deleteStoreById(@PathVariable(required = true) Long id)
			throws NumberFormatException, Exception {

		Optional<Store> store = repository.findById(id);
		if (store.isPresent()) {
			// Store obj = mapper.map(store, Store.class);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/{id}")
	@CacheEvict(allEntries = true)
	@Operation(summary = "Retrieve a store by id.")
	public ResponseEntity<Store> findStoreById(@PathVariable(name = "id", required = true) Long id)
			throws NumberFormatException, Exception {
		Store store = service.findByIdStore(id);
		if (store != null) {
			return ResponseEntity.ok(store);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
