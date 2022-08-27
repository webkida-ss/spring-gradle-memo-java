package com.example.springmemogradlejava.service;

import com.example.springmemogradlejava.entity.main.Shop;
import com.example.springmemogradlejava.repository.main.AppUserJpaRepository;
import com.example.springmemogradlejava.repository.main.ShopJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public void saveAll() {
        System.out.println("ログ");
        List<Shop> list = shopJpaRepository.findAll();
        int id = list.stream()
                .mapToInt(Shop::getId).max().getAsInt() + 1;
        List<Shop> shopList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int targetId = id + i;
            System.out.println(targetId);
            Shop shop = new Shop(targetId, "店舗" + targetId, LocalDate.of(2022, 1, 1));
            shopList.add(shop);
        }
        shopJpaRepository.saveAll(shopList);// 登録データをセット
        shopJpaRepository.flush();// DBに反映
    }
    public void delete() {
        System.out.println("ログ");
        List<Shop> list = shopJpaRepository.findAll();
        int id = list.stream()
                .mapToInt(Shop::getId).max().getAsInt();
        shopJpaRepository.deleteById(id);
    }

    public List<Shop> findByNameEquals(String shopName) {
        System.out.println("ログ");
        System.out.println(shopName);
        return shopJpaRepository.findByNameEquals(shopName);
    }
}
