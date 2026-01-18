package pl.g3devELopers.todoapp.mapper.task.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.dto.task.TaskDto;
import pl.g3devELopers.todoapp.service.TaskService;

@Component
@RequiredArgsConstructor
public class BlockTaskDtoMapper {
    private final TaskService taskService;
    private final TaskDtoMapper taskDtoMapper;

    public TaskDto blockTaskDtoMapper(Long id) {
        Task task = taskService.completeTask(id);
        return taskDtoMapper.map(task);
    }
}
