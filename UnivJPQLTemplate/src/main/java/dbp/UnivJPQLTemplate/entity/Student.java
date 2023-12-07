package dbp.UnivJPQLTemplate.entity;

//package를 직접 import한 후 진행

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Long id;
    private String name;
    private String address;

    @ManyToOne(targetEntity = Dept.class)
    @JoinColumn(name = "did", foreignKey = @ForeignKey(name = "fk_student_did"))
    private Dept dept;
}