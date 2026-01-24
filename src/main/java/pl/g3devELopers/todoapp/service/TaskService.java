package pl.g3devELopers.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.g3devELopers.todoapp.domain.CreateTask;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.mapper.task.domain.CompleteTaskMapper;
import pl.g3devELopers.todoapp.mapper.task.domain.ReopenTaskMapper;
import pl.g3devELopers.todoapp.mapper.task.domain.TaskListMapper;
import pl.g3devELopers.todoapp.mapper.task.domain.TaskMapper;
import pl.g3devELopers.todoapp.mapper.task.entity.TaskEntityMapper;
import pl.g3devELopers.todoapp.model.TaskEntity;
import pl.g3devELopers.todoapp.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskListMapper taskListMapper;
    private final CompleteTaskMapper completeTaskMapper;
    private final ReopenTaskMapper reopenTaskMapper;
    private final TaskEntityMapper taskEntityMapper;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public List<Task> getTaskList() {
        return taskListMapper.taskListMapper();
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task addTask(CreateTask createTask) {
        TaskEntity taskEntity = taskEntityMapper.createTaskEntityRequest(createTask);
        TaskEntity savedTaskEntity = taskRepository.save(taskEntity);
        return taskMapper.map(savedTaskEntity);
    }

    public Task completeTask(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found."));
        taskEntity.setTaskComplete(true);
        taskRepository.save(taskEntity);
        return taskMapper.map(taskEntity);
    }

    public Task reopenTask(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("Task not found."));
        taskEntity.setTaskComplete(false);
        taskRepository.save(taskEntity);
        return taskMapper.map(taskEntity);
    }

}
