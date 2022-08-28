package com.example.springmemogradlejava.entity.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

    @Column(name = "div_id")// FKはカラム名を明示しないとDuplicateMappingException
    private String divId;

    @ManyToOne // dept（部門）：div（事業部）= 多：1
    @JoinColumn(name = "div_id", insertable = false, updatable = false)// joinカラムでfindすると結合しながら取得可能
    private Div div;// insertable = false, updatable = false 参照用で有ることを示す
}
