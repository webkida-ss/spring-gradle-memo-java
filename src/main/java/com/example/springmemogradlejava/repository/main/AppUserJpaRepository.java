package com.example.springmemogradlejava.repository.main;

import com.example.springmemogradlejava.entity.main.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserJpaRepository extends JpaRepository<AppUser, Integer> {
}
