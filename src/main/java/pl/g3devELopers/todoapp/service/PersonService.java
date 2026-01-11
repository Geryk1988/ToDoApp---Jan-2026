package pl.g3devELopers.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.dto.CreatePersonRequest;
import pl.g3devELopers.todoapp.mapper.CreatePersonRequestMapper;
import pl.g3devELopers.todoapp.mapper.PersonMapper;
import pl.g3devELopers.todoapp.model.PersonEntity;
import pl.g3devELopers.todoapp.repository.PersonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final CreatePersonRequestMapper createPersonRequestMapper;
    private final PersonMapper personMapper;

    public List<Person> getList(String name){
        List<PersonEntity> personEntityList = personRepository.findAllByName(name);
        return personMapper.map(personEntityList);
    }

    public ResponseEntity<?> addPerson(CreatePersonRequest createPersonRequest){
        return createPersonRequestMapper.createPersonRequest(createPersonRequest);

    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
