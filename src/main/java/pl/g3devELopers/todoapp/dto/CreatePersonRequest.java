package pl.g3devELopers.todoapp.dto;

import jakarta.persistence.Column;

public record CreatePersonRequest(String name, String surname, String email) {
}
