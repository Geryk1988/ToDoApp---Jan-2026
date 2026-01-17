package pl.g3devELopers.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.g3devELopers.todoapp.dto.task.TaskDto;
import pl.g3devELopers.todoapp.mapper.task.dto.TaskDtoListMapper;
import pl.g3devELopers.todoapp.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskDtoListMapper taskDtoListMapper;

    @GetMapping("")
    public List<TaskDto> taskDtoList() {
        return taskDtoListMapper.taskDtoListMapper();
    }
}
