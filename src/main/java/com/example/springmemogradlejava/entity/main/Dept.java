package com.example.springmemogradlejava.entity.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "dept", schema = "main")
public class Dept {
    @Id
    private int id;
    private String name;

    // JoinColumnとでカラムかぶりするので、insertableを指定（デフォルトtrueなのでなくてもOK）
    @Column(name = "div_id", insertable = true, updatable = true)// FKはカラム名を明示しないとDuplicateMappingException
    private Integer divId;// ここにセットした値がデータ登録される

    @ManyToOne // dept（部門）：div（事業部）= 多：1
    @JoinColumn(name = "div_id", insertable = false, updatable = false)// joinカラムでfindすると結合しながら取得可能
    private Div div;// insertable = false, updatable = false 参照用の値であることを明示





    // 部署（dept）:ユーザ（user）= 1:多  mappedByには対抗先の変数名を指定する
    // https://gist.github.com/momotar/edccbea0e9712a3b3a6e
//    @OneToMany(mappedBy = "dept")
//    private List<AppUser> appUserList;
}
