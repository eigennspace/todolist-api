package com.example.todolistapi.subtodo;

import com.example.todolistapi.todo.ToDoResponseDTO;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubToDoResponseDTO {

    private BigInteger id;

    private ToDoResponseDTO toDoResponseDTO;

    private boolean isDone;


}
