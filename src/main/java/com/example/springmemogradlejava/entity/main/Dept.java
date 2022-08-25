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
@Table(name = "dept", schema = "main")
public class Dept {
    @Id
    private int id;
    private String name;
    private String divId;
}
