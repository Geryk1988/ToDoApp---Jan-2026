package pl.g3devELopers.todoapp.mapper.person;

import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.dto.PersonDto;

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
        return new PersonDto(person.name(), person.surname(), person.email());
    }
}
