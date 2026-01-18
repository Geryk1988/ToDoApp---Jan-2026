package pl.g3devELopers.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.domain.CreatePerson;
import pl.g3devELopers.todoapp.mapper.person.domain.BlockPersonMapper;
import pl.g3devELopers.todoapp.mapper.person.CreatePersonMapper;
import pl.g3devELopers.todoapp.mapper.person.domain.PersonListMapper;
import pl.g3devELopers.todoapp.mapper.person.domain.UnblockPersonMapper;
import pl.g3devELopers.todoapp.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final CreatePersonMapper createPersonMapper;
    private final BlockPersonMapper blockPersonMapper;
    private final PersonListMapper personListMapper;
    private final UnblockPersonMapper unblockPersonMapper;

    public List<Person> getList(String email){
        return personListMapper.personListMapper(email);
    }

    public ResponseEntity<?> addPerson(CreatePerson createPerson){
        return createPersonMapper.createPersonRequest(createPerson);

    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person blockPerson(Long id) {
        return blockPersonMapper.blockPersonMapper(id);
    }

    public Person unblockPerson(Long id) {
        return unblockPersonMapper.unblockPersonMapper(id);
    }
}
