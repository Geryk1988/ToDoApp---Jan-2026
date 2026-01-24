package pl.g3devELopers.todoapp.mapper.person.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.model.PersonEntity;
import pl.g3devELopers.todoapp.repository.PersonRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PersonListMapper {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    public List<Person> personListMapper(String email) {
        if (email == null || email.isEmpty()){
            List<PersonEntity> personEntityList = personRepository.findAll();
            return personMapper.map(personEntityList);
        }
        List<PersonEntity> personEntityList = personRepository.findAllByEmail(email);
        return personMapper.map(personEntityList);
    }
}