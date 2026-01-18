package pl.g3devELopers.todoapp.mapper.task.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.model.TaskEntity;
import pl.g3devELopers.todoapp.repository.TaskRepository;

@Component
@RequiredArgsConstructor
public class ReopenTaskMapper {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public Task reopenTaskMapper(Long id) {
        TaskEntity reopenTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
        reopenTask.setTaskComplete(false);
        taskRepository.save(reopenTask);
        return taskMapper.map(reopenTask);
    }
}
