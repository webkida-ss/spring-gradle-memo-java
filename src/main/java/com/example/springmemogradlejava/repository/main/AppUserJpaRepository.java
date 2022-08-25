package com.example.springmemogradlejava.repository.main;

import com.example.springmemogradlejava.entity.main.APP_USER;
import com.example.springmemogradlejava.entity.main.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserJpaRepository extends JpaRepository<APP_USER, Integer> {
}
