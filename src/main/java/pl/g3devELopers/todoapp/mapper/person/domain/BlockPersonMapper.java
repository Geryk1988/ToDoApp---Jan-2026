package pl.g3devELopers.todoapp.mapper.person.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.model.PersonEntity;
import pl.g3devELopers.todoapp.repository.PersonRepository;

@Component
@RequiredArgsConstructor
public class BlockPersonMapper {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    public Person blockPersonMapper(Long id) {
        PersonEntity blockPerson = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
        return personMapper.map(blockPerson);
    }
}
