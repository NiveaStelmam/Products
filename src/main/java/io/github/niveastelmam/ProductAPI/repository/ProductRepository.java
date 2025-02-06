package io.github.niveastelmam.ProductAPI.repository;

// FAZ AS OPERAÇÕES NO BANCO DE DADOS

import io.github.niveastelmam.ProductAPI.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
