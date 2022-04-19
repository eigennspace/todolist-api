package com.example.todolistapi;

import com.example.todolistapi.subtodo.SubToDo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String title;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    Date createdAt;

    @UpdateTimestamp
    Date updatedAt;

    @OneToMany(mappedBy = "toDo")
    private List<SubToDo> subToDoList;
}
