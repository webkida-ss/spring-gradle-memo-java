package com.example.springmemogradlejava.repository.main;

import com.example.springmemogradlejava.entity.main.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptJpaRepository extends JpaRepository<Dept, Integer> {
}
