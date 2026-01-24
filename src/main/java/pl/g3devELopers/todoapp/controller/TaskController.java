package pl.g3devELopers.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.g3devELopers.todoapp.domain.CreateTask;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.dto.task.TaskDto;
import pl.g3devELopers.todoapp.mapper.task.dto.BlockTaskDtoMapper;
import pl.g3devELopers.todoapp.mapper.task.dto.TaskDtoListMapper;
import pl.g3devELopers.todoapp.mapper.task.dto.TaskDtoMapper;
import pl.g3devELopers.todoapp.mapper.task.dto.UnblockTaskDtoMapper;
import pl.g3devELopers.todoapp.service.TaskService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final TaskDtoListMapper taskDtoListMapper;
    private final BlockTaskDtoMapper blockTaskDtoMapper;
    private final UnblockTaskDtoMapper unblockTaskDtoMapper;
    private final TaskDtoMapper taskDtoMapper;

    @GetMapping("")
    public List<TaskDto> taskDtoList() {
        return taskDtoListMapper.taskDtoListMapper();
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PostMapping("")
    public TaskDto addTask(@RequestBody CreateTask createTask){
        Task task = taskService.addTask(createTask);
        return taskDtoMapper.map(task);
    }

    @PatchMapping("/{id}/block")
    public TaskDto blockTaskDto(@PathVariable Long id){
    Task task = taskService.completeTask(id);
        return taskDtoMapper.map(task);
    }

    @PatchMapping("/{id}/unblock")
    public TaskDto unblockTaskDto(@PathVariable Long id){
        Task task = taskService.reopenTask(id);
        return taskDtoMapper.map(task);
    }
}
