package pl.g3devELopers.todoapp.mapper.task.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.model.TaskEntity;
import pl.g3devELopers.todoapp.repository.TaskRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskListMapper {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public List<Task> taskListMapper() {
        List<TaskEntity> taskEntityList = taskRepository.findAll();
        return taskMapper.map(taskEntityList);
    }
}
