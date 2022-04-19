package com.example.todolistapi.subtodo;

import com.example.todolistapi.todo.ToDoRequestDTO;
import lombok.*;

import java.math.BigInteger;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubToDoRequestDTO {
    private BigInteger id;

    private ToDoRequestDTO toDoRequestDTO;

    private boolean isDone;

    public SubToDo convertToEntity(){
        return SubToDo.builder().id(this.id).toDo(this.toDoRequestDTO.convertToEntity()).isDone(this.isDone).build();
    }


}
