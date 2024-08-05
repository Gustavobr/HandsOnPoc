package br.com.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.poc.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

}
