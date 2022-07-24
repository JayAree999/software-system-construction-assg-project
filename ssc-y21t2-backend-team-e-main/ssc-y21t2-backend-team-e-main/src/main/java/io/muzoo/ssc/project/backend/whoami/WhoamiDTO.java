package io.muzoo.ssc.project.backend.whoami;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.muzoo.ssc.project.backend.entity.Todo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.MutablePropertyValues;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public class WhoamiDTO {

    private boolean loggedIn = false;

    private String username;

    private String name;
    private Long id;

    private String role;

    private List<Todo> todoList = new ArrayList<>();
}
