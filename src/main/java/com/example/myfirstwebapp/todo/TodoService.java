package com.example.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 3;

    static {
        todos.add(new Todo(1, "daev", "Learn AWS", LocalDate.now().plusWeeks(2), false));
        todos.add(new Todo(2, "daev", "Learn DevOps", LocalDate.now().plusWeeks(5), false));
        todos.add(new Todo(3, "daev", "Learn Fullstack", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, Boolean isDone){
        Todo todo = new Todo(++todosCount, username, description, targetDate, isDone);
        todos.add(todo);
    }
}
