package pl.g3devELopers.todoapp.mapper.person.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.model.PersonEntity;
import pl.g3devELopers.todoapp.repository.PersonRepository;

@Component
@RequiredArgsConstructor
public class UnblockPersonMapper {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    public Person unblockPersonMapper(Long id) {
        PersonEntity blockPerson = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
        blockPerson.setBlocked(false);
        personRepository.save(blockPerson);
        return personMapper.map(blockPerson);
    }
}
