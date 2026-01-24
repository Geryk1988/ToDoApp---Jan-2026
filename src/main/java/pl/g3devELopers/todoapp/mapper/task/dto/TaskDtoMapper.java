package pl.g3devELopers.todoapp.mapper.task.dto;

import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.dto.task.TaskDto;

import java.util.Collections;
import java.util.List;

@Component
public class TaskDtoMapper {
    public List<TaskDto> map(List<Task> taskList) {
        if (taskList == null || taskList.isEmpty()){
            return Collections.emptyList();
        }
        return taskList.stream()
                .map(task -> map(task))
                .toList();
    }
    public TaskDto map(Task task){
        return new TaskDto(task.id(), task.taskName(), task.taskDesc());
    }
}
