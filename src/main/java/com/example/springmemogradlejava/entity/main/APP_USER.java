package com.example.springmemogradlejava.entity.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "app_user", schema = "main")
public class APP_USER {
    @Id
    private int id;
    private int deptId;
    private String firstName;
    private String lastName;
    private String remarks;
}
