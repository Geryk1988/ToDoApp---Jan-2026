package pl.g3devELopers.todoapp.mapper.task.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.CreateTask;
import pl.g3devELopers.todoapp.model.TaskEntity;
import pl.g3devELopers.todoapp.repository.TaskRepository;

@Component
@RequiredArgsConstructor
public class CreateTaskMapper {
    private final TaskRepository taskRepository;

    public ResponseEntity<?> createTaskRequest(CreateTask createTask) {
        taskRepository.save(TaskEntity.builder()
                .taskName(createTask.taskName())
                .taskDesc(createTask.taskDesc())
                .build());
        return ResponseEntity.ok(createTask);
    }
}
