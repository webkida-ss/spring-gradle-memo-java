package com.example.springmemogradlejava.service;

import com.example.springmemogradlejava.entity.main.AppUser;
import com.example.springmemogradlejava.entity.main.Dept;
import com.example.springmemogradlejava.entity.main.Div;
import com.example.springmemogradlejava.entity.main.Shop;
import com.example.springmemogradlejava.repository.main.AppUserJpaRepository;
import com.example.springmemogradlejava.repository.main.DeptJpaRepository;
import com.example.springmemogradlejava.repository.main.DivJpaRepository;
import com.example.springmemogradlejava.repository.main.ShopJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestService {
    private final ShopJpaRepository shopJpaRepository;
    private final AppUserJpaRepository appUserJpaRepository;

    private final DeptJpaRepository deptJpaRepository;
    private final DivJpaRepository divJpaRepository;

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

    public List<Dept> dept1() {
        System.out.println("ログ");
        List<Dept> list = deptJpaRepository.findAll().subList(0, 2);
        list.forEach(e -> System.out.println(e.getDiv()));
        return list;
    }

    public void dept2() {
        System.out.println("ログ");
        Div div = new Div();
        div.setId(29000);
        int deptId = 30000;
        Dept dept = new Dept();
        dept.setId(deptId);
        dept.setName("deptテスト"+deptId);
        dept.setDiv(div);
        dept.setDivId(29500);
        deptJpaRepository.saveAndFlush(dept);
    }
    public Dept dept3(Integer deptId) {
        System.out.println("ログ");
        Dept dept = deptJpaRepository.findById(deptId).get();
        System.out.println(dept.getAppUserList().size());
        return dept;
    }

    public void dept4(Integer deptId) {
        System.out.println("ログ");
        deptJpaRepository.deleteById(deptId);// 伝搬する設定のため、ユーザも消される！
    }


//
//    public void dept2() {
//        System.out.println("ログ");
//        List<AppUser> userList = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            int userid = 58064 + i;
//            AppUser user = new AppUser();
//            user.setId(userid);
//            user.setFirstName("user" + userid);
//            userList.add(user);
//        }
//        Dept dept = new Dept();
//        dept.setId(30001);
//        dept.setName("dept30001");
//        dept.setAppUserList(userList);
//        deptJpaRepository.saveAndFlush(dept);
//    }
//

//
//    public List<AppUser> user2() {
//        System.out.println("ログ");
//        int deptId = 30001;
////                appUserJpaRepository.findAll().stream()
////                .mapToInt(AppUser::getId).max().getAsInt() + 1;
//        int userId = 58064;
////                appUserJpaRepository.findAll().stream()
////                .mapToInt(AppUser::getId).max().getAsInt() + 1;
////        System.out.println(deptId);
////        System.out.println(userId);
//        Dept dept = new Dept();
////        dept.setId(deptId);
//        dept.setDivId(1);
//
//        AppUser user = new AppUser(0, "first" + userId, "last" + userId, "", dept);
//
//        appUserJpaRepository.saveAndFlush(user);
//
////        return appUserJpaRepository.findAll().stream().sorted(Comparator.comparing(AppUser::getId).reversed())
////                .collect(Collectors.toList())
////                .subList(1, 2);
//        return null;
//    }
}
