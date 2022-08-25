package com.example.springmemogradlejava.repository.main;

import com.example.springmemogradlejava.entity.main.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopJpaRepository extends JpaRepository<Shop, Integer> {
}
