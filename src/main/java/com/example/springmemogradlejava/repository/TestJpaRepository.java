package com.example.springmemogradlejava.repository;

import com.example.springmemogradlejava.entity.main.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestJpaRepository extends JpaRepository<Shop, Integer> {
}
