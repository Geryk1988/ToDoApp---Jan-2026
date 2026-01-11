package pl.g3devELopers.todoapp.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.dto.CreatePersonRequest;
import pl.g3devELopers.todoapp.model.PersonEntity;
import pl.g3devELopers.todoapp.repository.PersonRepository;

@Component
@RequiredArgsConstructor
public class CreatePersonRequestMapper {

    private final PersonRepository personRepository;

    public ResponseEntity<?> createPersonRequest(CreatePersonRequest createPersonRequest) {
        personRepository.save(PersonEntity.builder()
                .name(createPersonRequest.name())
                .surname(createPersonRequest.surname())
                .email(createPersonRequest.email())
                .build());

        return ResponseEntity.ok(createPersonRequest);
    }
}

