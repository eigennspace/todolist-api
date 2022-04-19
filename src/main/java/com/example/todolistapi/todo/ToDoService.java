package com.example.todolistapi.todo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDo createToDo(ToDo toDo){
        return this.toDoRepository.save(toDo);
    }

    public List<ToDo> getAllToDos(){
        return this.toDoRepository.findAll();
    }

    public ToDo getOne(BigInteger id){
        Optional<ToDo> optionalToDo = this.toDoRepository.findById(id);

        if (!optionalToDo.isPresent()){
            throw new ToDoNotFoundException();
        }
        return optionalToDo.get();
    }
    
    public ToDo updateToDo(ToDo toDo){
        this.getOne(toDo.getId());

        return this.toDoRepository.save(toDo);
    }

    public void deleteToDo(ToDo toDo){
        ToDo deleteTodo = this.getOne(toDo.getId());

        this.toDoRepository.delete(deleteTodo);
    }
}
