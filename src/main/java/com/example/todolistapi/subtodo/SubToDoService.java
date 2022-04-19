package com.example.todolistapi.subtodo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubToDoService {
    private final SubToDoRepository subToDoRepository;

    public SubToDo create(SubToDo subToDo){
        return this.subToDoRepository.save(subToDo);
    }

    public List<SubToDo> getSubToDos(){
        return this.subToDoRepository.findAll();
    }

    public SubToDo getOne(BigInteger id){
        Optional<SubToDo> optionalSubToDo = this.subToDoRepository.findById(id);

        if (!optionalSubToDo.isPresent()){
            throw new SubToDoNotFoundException();
        }

        return optionalSubToDo.get();
    }

    public SubToDo updateSubToDo(SubToDo subToDo){
        this.getOne(subToDo.getId());

        return this.subToDoRepository.save(subToDo);
    }

    public void deleteSubToDo(SubToDo subToDo){
        SubToDo deleteSubToDo = this.getOne(subToDo.getId());

        this.subToDoRepository.delete(deleteSubToDo);
    }
}
