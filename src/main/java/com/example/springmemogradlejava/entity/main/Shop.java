package com.example.springmemogradlejava.entity.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "shop", schema = "main")
public class Shop {
    @Id
    private int id;

    private String name;

    @Column(name = "established_date")
    private LocalDate foundationDate;// establishedDateをマッピング
}
