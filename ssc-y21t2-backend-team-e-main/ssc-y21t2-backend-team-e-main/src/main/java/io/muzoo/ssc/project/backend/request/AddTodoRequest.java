package io.muzoo.ssc.project.backend.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AddTodoRequest {
    private String content;
    private String dueDate;
    private List<Long> ids;
    private Long id;
    private String remindTime;


    public String getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(String remindTime) {
        this.remindTime = remindTime;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public AddTodoRequest(){

    }

    public AddTodoRequest(String content){
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public long getTodoID() {
        return id;

    }

    public void setId(Long id) {
        this.id = id;
    }


}

