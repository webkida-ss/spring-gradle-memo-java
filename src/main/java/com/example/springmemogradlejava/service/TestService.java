package com.example.springmemogradlejava.service;

import com.example.springmemogradlejava.entity.main.Shop;
import com.example.springmemogradlejava.repository.TestJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService{
    private final TestJpaRepository testJpaRepository;

    public List<Shop> findAll(){
        List<Shop> list = testJpaRepository.findAll();
        return list;
    }
}
