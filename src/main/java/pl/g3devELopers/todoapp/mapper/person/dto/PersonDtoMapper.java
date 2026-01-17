package pl.g3devELopers.todoapp.mapper.person.dto;

import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.dto.person.PersonDto;

import java.util.Collections;
import java.util.List;

@Component
public class PersonDtoMapper {
    public List<PersonDto> map(List<Person> personList) {
        if (personList == null || personList.isEmpty()){
            return Collections.emptyList();
        }
        return personList.stream()
                .map(person -> map(person))
                .toList();
    }
    public PersonDto map(Person person){
        return new PersonDto(person.id(), person.name(), person.surname(), person.email());
    }
}
