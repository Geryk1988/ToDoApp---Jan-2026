package pl.g3devELopers.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.g3devELopers.todoapp.dto.CreatePerson;
import pl.g3devELopers.todoapp.dto.PersonDto;
import pl.g3devELopers.todoapp.mapper.person.PersonDtoListMapper;
import pl.g3devELopers.todoapp.service.PersonService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    private final PersonDtoListMapper personDtoListMapper;

    @GetMapping("/list")
    public List<PersonDto> personDtoList(@RequestParam(required = false) String email){
        return personDtoListMapper.personDtoListMapper(email);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPerson(@RequestBody CreatePerson createPerson){
            return personService.addPerson(createPerson);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id){
            personService.deletePerson(id);
    }

}
