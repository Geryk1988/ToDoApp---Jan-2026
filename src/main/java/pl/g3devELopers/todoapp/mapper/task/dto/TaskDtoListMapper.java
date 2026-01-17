package pl.g3devELopers.todoapp.mapper.task.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.dto.task.TaskDto;
import pl.g3devELopers.todoapp.service.TaskService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskDtoListMapper {
    private final TaskService taskService;
    private final TaskDtoMapper taskDtoMapper;

    public List<TaskDto> taskDtoListMapper() {
        List<Task> taskList = taskService.getTaskList();
        return taskDtoMapper.map(taskList);
    }
}
