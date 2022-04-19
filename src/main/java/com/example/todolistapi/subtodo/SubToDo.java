package com.example.todolistapi.subtodo;

import com.example.todolistapi.todo.ToDo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SubToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    @JsonIgnore
    private ToDo toDo;

    private boolean isDone;

    public SubToDoResponseDTO convertToResponse(){
        return SubToDoResponseDTO.builder().id(this.id).toDoResponseDTO(this.toDo.convertToResponse())
                .isDone(this.isDone).build();
    }
}
