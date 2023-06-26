package com.prokopovich.todo_list.repository;

import com.prokopovich.todo_list.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {

}
