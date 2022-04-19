package com.example.todolistapi.todo;

import com.example.todolistapi.subtodo.SubToDo;
import lombok.*;
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
@Builder
@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String title;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @OneToMany(mappedBy = "toDo", cascade = CascadeType.PERSIST)
    private List<SubToDo> subToDoList;

    private boolean isComplete;

    public ToDoResponseDTO convertToResponse(){
        return ToDoResponseDTO.builder().id(this.id).title(this.title).createdAt(this.createdAt)
                .updatedAt(this.updatedAt).subToDoList(this.subToDoList).build();
    }
}
