package pl.g3devELopers.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.mapper.task.domain.TaskListMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskListMapper taskListMapper;

    public List<Task> getTaskList() {
        return taskListMapper.taskListMapper();
    }
}
