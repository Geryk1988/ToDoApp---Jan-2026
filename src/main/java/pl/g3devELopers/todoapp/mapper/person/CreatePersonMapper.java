package pl.g3devELopers.todoapp.mapper.person;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.dto.CreatePerson;
import pl.g3devELopers.todoapp.model.PersonEntity;
import pl.g3devELopers.todoapp.repository.PersonRepository;

@Component
@RequiredArgsConstructor
public class CreatePersonMapper {

    private final PersonRepository personRepository;

    public ResponseEntity<?> createPersonRequest(CreatePerson createPerson) {
        personRepository.save(PersonEntity.builder()
                .name(createPerson.name())
                .surname(createPerson.surname())
                .email(createPerson.email())
                .build());

        return ResponseEntity.ok(createPerson);
    }
}

