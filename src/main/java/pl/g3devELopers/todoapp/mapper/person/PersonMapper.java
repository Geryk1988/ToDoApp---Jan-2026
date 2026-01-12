package pl.g3devELopers.todoapp.mapper.person;

import org.springframework.stereotype.Service;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.model.PersonEntity;

import java.util.Collections;
import java.util.List;

@Service
public class PersonMapper {

    public List<Person> map(List<PersonEntity> personEntityList) {
        if (personEntityList == null || personEntityList.isEmpty()){
            return Collections.emptyList();
        }
        return personEntityList.stream()
                .map(personEntity -> map(personEntity))
                .toList();
    }
    public Person map(PersonEntity personEntity){
        return new Person(personEntity.getName(), personEntity.getSurname(), personEntity.getEmail());
    }
}
