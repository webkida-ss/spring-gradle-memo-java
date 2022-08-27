package com.example.springmemogradlejava.service;

import com.example.springmemogradlejava.entity.main.Shop;
import com.example.springmemogradlejava.repository.main.AppUserJpaRepository;
import com.example.springmemogradlejava.repository.main.ShopJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final ShopJpaRepository shopJpaRepository;
    private final AppUserJpaRepository appUserJpaRepository;

    public List<Shop> findAll() {
        System.out.println("ログ");
        List<Shop> list = shopJpaRepository.findAll();
        System.out.println(appUserJpaRepository.findById(10));
        return list;
    }

    public void saveAndFlush() {
        System.out.println("ログ");
        List<Shop> list = shopJpaRepository.findAll();
        int id = list.stream()
                .mapToInt(Shop::getId).max().getAsInt() + 1;
        shopJpaRepository.saveAndFlush(new Shop(id,
                "店舗" + id, LocalDate.of(2022, 1, 1)));
    }
}
