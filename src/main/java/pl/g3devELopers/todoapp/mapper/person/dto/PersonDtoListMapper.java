package pl.g3devELopers.todoapp.mapper.person.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.dto.person.PersonDto;
import pl.g3devELopers.todoapp.service.PersonService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonDtoListMapper {
    private final PersonService personService;
    private final PersonDtoMapper personDtoMapper;

    public List<PersonDto> personDtoListMapper(String email) {
        if (email == null || email.isEmpty()){
            List<Person> personList = personService.getList(email);
            return personDtoMapper.map(personList);
        }
        List<Person> personList = personService.getList(email);
        return personDtoMapper.map(personList);
    }
}
