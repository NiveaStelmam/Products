package io.github.niveastelmam.ProductAPI.repository;

// FAZ AS OPERAÇÕES NO BANCO DE DADOS

import io.github.niveastelmam.ProductAPI.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findByName(String name);

}
