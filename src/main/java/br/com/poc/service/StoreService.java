package br.com.poc.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.poc.DTO.StoreDTO;
import br.com.poc.entity.Store;
import br.com.poc.repository.StoreRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
@ComponentScan(basePackageClasses = br.com.poc.configuration.Configuration.class)
public class StoreService {

	@Autowired

	private StoreRepository repository;

	@Autowired

	private ModelMapper mapper;

	public org.springframework.data.domain.Page<Store> obterTodos(Pageable paginacao) throws Exception {
		return repository.findAll(paginacao).map((p) -> mapper.map(p, Store.class));

	}

	public Store findByIdStore(Long id) {
		if (id != null) {
			Optional<Store> store = repository.findById(id);
			if (store != null) {
				Store DTO = mapper.map(store, Store.class);
				return DTO;
			}
		}
		return null;
	}

	public void addStore(StoreDTO storeDTO) {
		if (storeDTO != null) {
			Store store = mapper.map(storeDTO, Store.class);
			repository.saveAndFlush(store);

		}

	}
}
