package com.example.springmemogradlejava.entity.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "app_user", schema = "main")
public class AppUser {
    @Id
    private int id;
//    @Column(name = "dept_id")
//    private int deptId; // insertable = true, updatable = trueにするために削除
    private String firstName;
    private String lastName;
    private String remarks;

//    @ManyToOne
//    @JoinColumn(name = "dept_id", insertable = true, updatable = true)
//    private Dept dept;
}
