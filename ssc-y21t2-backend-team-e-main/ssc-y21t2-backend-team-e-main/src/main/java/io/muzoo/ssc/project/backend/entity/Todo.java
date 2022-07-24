package io.muzoo.ssc.project.backend.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tbl_todo")
public class Todo {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long todoID;
    @Column(unique = false)

    private String content;
    private String dueDate;



    public Todo(long todoID, String content, boolean completed) {
        this.todoID = todoID;
        this.content = content;
        this.dueDate = dueDate;

    }

    public long getTodoID() {
        return todoID;
    }

    public String getContent() {
        return content;
    }

    public String getDueDate() {
        return dueDate;
    }


    public Todo() {

    }
}