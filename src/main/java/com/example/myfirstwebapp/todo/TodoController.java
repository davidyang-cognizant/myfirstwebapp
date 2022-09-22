package com.example.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("daev");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @RequestMapping(value="add-todo", method=RequestMethod.GET)
    public String showNewTodoPage(ModelMap model) {
        String username = model.get("name").toString();
        Todo todo = new Todo(0, username, "" , LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="add-todo", method=RequestMethod.POST)
    public String addNewTodoPage(ModelMap model, Todo todo) {
        String username = model.get("name").toString();
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
}
