package pl.g3devELopers.todoapp.mapper.person.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.CreatePerson;
import pl.g3devELopers.todoapp.model.PersonEntity;
import pl.g3devELopers.todoapp.repository.PersonRepository;

@Component
@RequiredArgsConstructor
public class PersonEntityMapper {

    private final PersonRepository personRepository;

    public PersonEntity createPersonEntityRequest(CreatePerson createPerson) {
        return PersonEntity.builder()
                .name(createPerson.name())
                .surname(createPerson.surname())
                .email(createPerson.email())
                .build();
    }
}

