package com.example.springmemogradlejava.repository.main;

import com.example.springmemogradlejava.entity.main.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// https://qiita.com/shindo_ryo/items/af7d12be264c2cc4b252
public interface ShopJpaRepository extends JpaRepository<Shop, Integer> {
    List<Shop> findByNameEquals(String name);
}
