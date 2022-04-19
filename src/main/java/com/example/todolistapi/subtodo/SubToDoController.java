package com.example.todolistapi.subtodo;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SubToDoController {
    private final SubToDoService subToDoService;


    @PostMapping("/subtodo")
    public ResponseEntity<SubToDoResponseDTO> createSubToDo(@RequestBody SubToDoRequestDTO subToDoRequestDTO){
        SubToDo newSubToDo = subToDoRequestDTO.convertToEntity();

        SubToDo subToDo = this.subToDoService.create(newSubToDo);

        SubToDoResponseDTO toDoResponseDTO = subToDo.convertToResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(toDoResponseDTO);
    }
}
