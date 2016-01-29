package com.springapp.mvc.repository;

import com.springapp.mvc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
