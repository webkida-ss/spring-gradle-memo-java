package com.example.springmemogradlejava.service;

import com.example.springmemogradlejava.entity.main.Shop;
import com.example.springmemogradlejava.repository.main.AppUserJpaRepository;
import com.example.springmemogradlejava.repository.main.ShopJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService{
    private final ShopJpaRepository shopJpaRepository;
    private final AppUserJpaRepository appUserJpaRepository;

    public List<Shop> findAll(){
        System.out.println("ログ");
        List<Shop> list = shopJpaRepository.findAll();
        System.out.println(appUserJpaRepository.findById(10));
        return list;
    }
}
