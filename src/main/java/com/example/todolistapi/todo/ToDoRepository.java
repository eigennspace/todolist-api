package com.example.todolistapi.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, BigInteger> {
}
