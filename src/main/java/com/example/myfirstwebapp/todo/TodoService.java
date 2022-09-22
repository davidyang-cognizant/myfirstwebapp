package com.example.myfirstwebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 3;

    static {
        todos.add(new Todo(1, "daev", "Learn AWS Static", LocalDate.now().plusWeeks(2), false));
        todos.add(new Todo(2, "daev", "Learn DevOps Static", LocalDate.now().plusWeeks(5), false));
        todos.add(new Todo(3, "daev", "Learn Fullstack Static", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate targetDate, Boolean isDone){
        Todo todo = new Todo(++todosCount, username, description, targetDate, isDone);
        todos.add(todo);
    }


    public void removeTodo(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }


    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(@Valid Todo todo) {
        removeTodo(todo.getId());
        todos.add(todo);
    }
}
