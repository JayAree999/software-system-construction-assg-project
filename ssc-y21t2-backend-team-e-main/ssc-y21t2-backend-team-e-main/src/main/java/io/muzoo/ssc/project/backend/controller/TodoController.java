package io.muzoo.ssc.project.backend.controller;

import io.muzoo.ssc.project.backend.entity.Todo;
import io.muzoo.ssc.project.backend.repository.TodoRepository;
import io.muzoo.ssc.project.backend.request.AddTodoRequest;
import io.muzoo.ssc.project.backend.entity.UserDTO;
import io.muzoo.ssc.project.backend.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
@RequestMapping("/api/users")
@RestController
public class TodoController {

    private String sender;
    private String senderProfile;
    private String message;

    private UserRepository userRepository;
    private TodoRepository todoRepository;

    public TodoController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return userRepository.findUserById(userId).orElseThrow(() -> new NoSuchElementException());
    }


    @PostMapping("/{userId}/todos")
    public void addTodo(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest) {
        UserDTO user = userRepository.findUserById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = new Todo();
        todo.setContent(todoRequest.getContent());
        todo.setDueDate(todoRequest.getDueDate());

        user.getTodoList().add(todo);
        todoRepository.save(todo);
        userRepository.save(user);
    }


    @PostMapping("/{userId}/todos/edit")
    public void editSave(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest) {
        UserDTO user = userRepository.findUserById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = todoRepository.findById(todoRequest.getTodoID()).orElseThrow(() -> new NoSuchElementException());

        todo.setContent(todoRequest.getContent());
        todo.setDueDate(todoRequest.getDueDate());

        todoRepository.save(todo);
        userRepository.save(user);

    }


    @DeleteMapping("/{userId}/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId, @PathVariable Long userId) {
        UserDTO user = userRepository.findUserById(userId).orElseThrow(() -> new NoSuchElementException());
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NoSuchElementException());
        user.getTodoList().remove(todo);
        todoRepository.delete(todo);
    }

    @PostMapping("/{userId}/todos/delete")
    public void deleteTodos(@PathVariable Long userId, @RequestBody AddTodoRequest todoRequest) {
        UserDTO user = userRepository.findUserById(userId).orElseThrow(() -> new NoSuchElementException());

        for (Long id : todoRequest.getIds()) {
            Todo todo = todoRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
            user.getTodoList().remove(todo);
            todoRepository.delete(todo);
        }


    }



}
