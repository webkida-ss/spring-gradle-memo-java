package com.example.springmemogradlejava.controller;

import com.example.springmemogradlejava.entity.main.Shop;
import com.example.springmemogradlejava.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;

    @GetMapping("/test1")
    public String test1() {
        return testService.findAll().get(0).getName();
    }

    @GetMapping("/test2")
    public String test2() {
        testService.saveAndFlush();
        return "saveAndFlush";
    }

    @GetMapping("/test3")
    public String test3() {
        testService.saveAll();
        return "saveAll";
    }

    @GetMapping("/test4")
    public String test4() {
        testService.delete();
        return "delete";
    }

    @GetMapping("/test5")
    public Integer test5(@RequestParam(name = "shop_name") String shopName) {
        Shop shop =testService.findByNameEquals(shopName)
                .stream().findFirst().get();
        return shop.getId();
    }
}
