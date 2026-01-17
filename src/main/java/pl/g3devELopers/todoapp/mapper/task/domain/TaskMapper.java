package pl.g3devELopers.todoapp.mapper.task.domain;

import org.springframework.stereotype.Service;
import pl.g3devELopers.todoapp.domain.Task;
import pl.g3devELopers.todoapp.model.TaskEntity;

import java.util.Collections;
import java.util.List;

@Service
public class TaskMapper {
    public List<Task> map(List<TaskEntity> taskEntityList) {
        if (taskEntityList == null || taskEntityList.isEmpty()){
            return Collections.emptyList();
        }
        return taskEntityList.stream()
                .map(taskEntity -> map(taskEntity))
                .toList();
    }
    public Task map(TaskEntity taskEntity){
        return new Task(taskEntity.getId(), taskEntity.getTaskName(), taskEntity.getTaskDesc(), taskEntity.isTaskComplete());
    }
}
