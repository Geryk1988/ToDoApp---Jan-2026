package pl.g3devELopers.todoapp.domain;

public record Task(Long id, String taskName, String taskDesc, boolean isTaskComplete) {
}
