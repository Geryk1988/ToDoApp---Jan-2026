package pl.g3devELopers.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.g3devELopers.todoapp.domain.CreateTask;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.mapper.task.domain.CompleteTaskMapper;
import pl.g3devELopers.todoapp.mapper.task.domain.CreateTaskMapper;
import pl.g3devELopers.todoapp.mapper.task.domain.ReopenTaskMapper;
import pl.g3devELopers.todoapp.mapper.task.domain.TaskListMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskListMapper taskListMapper;
    private final CreateTaskMapper createTaskMapper;
    private final CompleteTaskMapper completeTaskMapper;
    private final ReopenTaskMapper reopenTaskMapper;

    public List<Task> getTaskList() {
        return taskListMapper.taskListMapper();
    }

    public ResponseEntity<?> addTask(CreateTask createTask) {
        return createTaskMapper.createTaskRequest(createTask);
    }

    public Task completeTask(Long id) {
        return completeTaskMapper.completeTaskMapper(id);
    }

    public Task reopenTask(Long id) {
        return reopenTaskMapper.reopenTaskMapper(id);
    }
}
