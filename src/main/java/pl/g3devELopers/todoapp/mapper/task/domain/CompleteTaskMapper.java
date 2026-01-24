package pl.g3devELopers.todoapp.mapper.task.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.model.TaskEntity;
import pl.g3devELopers.todoapp.repository.TaskRepository;

@Component
@RequiredArgsConstructor
public class CompleteTaskMapper {
    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public Task completeTaskMapper(Long id) {
        TaskEntity completeTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
        completeTask.setTaskComplete(true);
        taskRepository.save(completeTask);
        return taskMapper.map(completeTask);
    }
}
