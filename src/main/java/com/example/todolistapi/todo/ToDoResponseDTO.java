package com.example.todolistapi.todo;

import com.example.todolistapi.subtodo.SubToDo;
import lombok.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoResponseDTO {
    private BigInteger id;

    private String title;

    private Date createdAt;

    private Date updatedAt;

    private List<SubToDo> subToDoList;

    private boolean isComplete;
}
