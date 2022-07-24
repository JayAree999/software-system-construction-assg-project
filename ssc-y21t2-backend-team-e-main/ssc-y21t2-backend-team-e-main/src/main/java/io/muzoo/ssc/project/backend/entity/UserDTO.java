package io.muzoo.ssc.project.backend.entity;


import io.muzoo.ssc.project.backend.entity.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tbl_user")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String lineID;
    private String email;
    private String discordWebHook;
    private String role;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Todo> todoList = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }



}