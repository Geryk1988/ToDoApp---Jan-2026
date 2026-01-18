package pl.g3devELopers.todoapp.mapper.person.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.dto.person.PersonDto;
import pl.g3devELopers.todoapp.service.PersonService;

@Component
@RequiredArgsConstructor
public class BlockPersonDtoMapper {
    private final PersonService personService;
    private final PersonDtoMapper personDtoMapper;

    public PersonDto blockPersonDtoMapper(Long id) {
        Person person = personService.blockPerson(id);
        return personDtoMapper.map(person);
    }
}
