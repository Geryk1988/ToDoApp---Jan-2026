package pl.g3devELopers.todoapp.mapper.task.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.CreateTask;
import pl.g3devELopers.todoapp.model.TaskEntity;
import pl.g3devELopers.todoapp.repository.TaskRepository;

@Component
@RequiredArgsConstructor
public class TaskEntityMapper {
    private final TaskRepository taskRepository;

    public TaskEntity createTaskEntityRequest(CreateTask createTask) {
        return TaskEntity.builder()
                .taskName(createTask.taskName())
                .taskDesc(createTask.taskDesc())
                .build();
    }
}
