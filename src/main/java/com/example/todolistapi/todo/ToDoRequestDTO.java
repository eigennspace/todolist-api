package com.example.todolistapi.todo;

import com.example.todolistapi.subtodo.SubToDo;
import com.example.todolistapi.subtodo.SubToDoRequestDTO;
import lombok.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ToDoRequestDTO {

    private String title;

    private SubToDoRequestDTO subToDoRequestDTO;

    private boolean isComplete;

    public ToDo convertToEntity(){
        return ToDo.builder().title(this.title).subToDoList(Arrays.asList(this.subToDoRequestDTO.convertToEntity())).isComplete(this.isComplete).build();
    }
}
