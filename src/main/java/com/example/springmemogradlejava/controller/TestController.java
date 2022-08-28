package com.example.springmemogradlejava.controller;

import com.example.springmemogradlejava.entity.main.AppUser;
import com.example.springmemogradlejava.entity.main.Dept;
import com.example.springmemogradlejava.entity.main.Div;
import com.example.springmemogradlejava.entity.main.Shop;
import com.example.springmemogradlejava.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/dept1")
    public List<Dept> dept1() {
        return testService.dept1();
    }

//    @GetMapping("/dept2")
//    public String dept() {
//        testService.dept2();
//        return "終わり";
//    }
//
//    @GetMapping("/user1")
//    public List<AppUser> user1() {
//        return testService.user1();
//    }
//
//    @GetMapping("/user2")
//    public List<AppUser> user2() {
//        return testService.user2();
//    }
}
