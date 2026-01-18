package pl.g3devELopers.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.g3devELopers.todoapp.domain.CreateTask;
import pl.g3devELopers.todoapp.dto.task.TaskDto;
import pl.g3devELopers.todoapp.mapper.task.dto.BlockTaskDtoMapper;
import pl.g3devELopers.todoapp.mapper.task.dto.TaskDtoListMapper;
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

    @GetMapping("")
    public List<TaskDto> taskDtoList() {
        return taskDtoListMapper.taskDtoListMapper();
    }

    @PostMapping("")
    public ResponseEntity<?> addTask(@RequestBody CreateTask createTask){
        return taskService.addTask(createTask);
    }

    @PatchMapping("/{id}/block")
    public TaskDto blockTaskDto(@PathVariable Long id){

        return blockTaskDtoMapper.blockTaskDtoMapper(id);
    }

    @PatchMapping("/{id}/unblock")
    public TaskDto unblockTaskDto(@PathVariable Long id){

        return unblockTaskDtoMapper.blockTaskDtoMapper(id);
    }
}
