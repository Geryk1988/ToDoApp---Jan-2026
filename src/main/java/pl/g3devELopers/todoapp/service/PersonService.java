package pl.g3devELopers.todoapp.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.g3devELopers.todoapp.domain.CreatePerson;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.mapper.person.domain.PersonListMapper;
import pl.g3devELopers.todoapp.mapper.person.domain.PersonMapper;
import pl.g3devELopers.todoapp.mapper.person.domain.UnblockPersonMapper;
import pl.g3devELopers.todoapp.mapper.person.entity.PersonEntityMapper;
import pl.g3devELopers.todoapp.model.PersonEntity;
import pl.g3devELopers.todoapp.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonEntityMapper personEntityMapper;
    private final PersonListMapper personListMapper;
    private final UnblockPersonMapper unblockPersonMapper;
    private final PersonMapper personMapper;

    public List<Person> getList(String email){

        return personListMapper.personListMapper(email);
    }

    public Person addPerson(CreatePerson createPerson){
        PersonEntity personEntity = personEntityMapper.createPersonEntityRequest(createPerson);
        PersonEntity savedPersonEntity = personRepository.save(personEntity);
        return personMapper.map(savedPersonEntity);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person blockPerson(Long id) {
        PersonEntity personEntity = personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person not found."));
        personEntity.setBlocked(true);
        personRepository.save(personEntity);
        return personMapper.map(personEntity);
    }

    public Person unblockPerson(Long id) {
        PersonEntity personEntity = personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person not found."));
        personEntity.setBlocked(false);
        personRepository.save(personEntity);
        return personMapper.map(personEntity);
    }
}
