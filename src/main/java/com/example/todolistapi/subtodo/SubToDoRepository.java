package com.example.todolistapi.subtodo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SubToDoRepository extends JpaRepository<SubToDo, BigInteger> {
}
