package pl.g3devELopers.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.dto.CreatePersonRequest;
import pl.g3devELopers.todoapp.dto.PersonDto;
import pl.g3devELopers.todoapp.mapper.PersonDtoMapper;
import pl.g3devELopers.todoapp.service.PersonService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final PersonDtoMapper personDtoMapper;

    @GetMapping("/list")
    public List<PersonDto> getList(@RequestParam String name){
        List<Person> personList = personService.getList(name);
        List<PersonDto> personDtoList = personDtoMapper.map(personList);
        return personDtoList;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPerson(@RequestBody CreatePersonRequest createPersonRequest){
            return personService.addPerson(createPersonRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id){
            personService.deletePerson(id);
    }

}
