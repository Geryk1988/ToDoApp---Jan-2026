package pl.g3devELopers.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.g3devELopers.todoapp.domain.CreatePerson;
import pl.g3devELopers.todoapp.domain.Person;
import pl.g3devELopers.todoapp.dto.person.PersonDto;
import pl.g3devELopers.todoapp.mapper.person.dto.PersonDtoListMapper;
import pl.g3devELopers.todoapp.mapper.person.dto.PersonDtoMapper;
import pl.g3devELopers.todoapp.service.PersonService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final PersonDtoListMapper personDtoListMapper;
    private final PersonDtoMapper personDtoMapper;

    @GetMapping("")
    public List<PersonDto> personDtoList(@RequestParam(required = false) String email){
        return personDtoListMapper.personDtoListMapper(email);
    }

    @PostMapping("")
    public PersonDto addPerson(@RequestBody CreatePerson createPerson){
        Person person = personService.addPerson(createPerson);
        return personDtoMapper.map(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @PatchMapping("/{id}/block")
    public PersonDto blockPersonDto(@PathVariable Long id){
        Person person = personService.blockPerson(id);
        return personDtoMapper.map(person);
    }

    @PatchMapping("/{id}/unblock")
    public PersonDto unblockPersonDto(@PathVariable Long id){
        Person person = personService.unblockPerson(id);
        return personDtoMapper.map(person);
    }

}
