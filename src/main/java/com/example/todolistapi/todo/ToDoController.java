package com.example.todolistapi.todo;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ToDoController {
    private final ToDoService toDoService;

    @PostMapping("/todo")
    public ResponseEntity<ToDoResponseDTO> createToDo(@RequestBody ToDoRequestDTO toDoRequestDTO){
        ToDo newToDo = toDoRequestDTO.convertToEntity();
        ToDo toDo = this.toDoService.createToDo(newToDo);

        ToDoResponseDTO toDoResponseDTO = toDo.convertToResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(toDoResponseDTO);
    }
}
