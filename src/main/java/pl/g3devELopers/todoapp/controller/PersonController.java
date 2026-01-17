package pl.g3devELopers.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.g3devELopers.todoapp.dto.person.CreatePerson;
import pl.g3devELopers.todoapp.dto.person.PersonDto;
import pl.g3devELopers.todoapp.mapper.person.dto.BlockPersonDtoMapper;
import pl.g3devELopers.todoapp.mapper.person.dto.PersonDtoListMapper;
import pl.g3devELopers.todoapp.mapper.person.dto.UnblockPersonDtoMapper;
import pl.g3devELopers.todoapp.service.PersonService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final PersonDtoListMapper personDtoListMapper;
    private final BlockPersonDtoMapper blockPersonDtoMapper;
    private final UnblockPersonDtoMapper unblockPersonDtoMapper;

    @GetMapping("")
    public List<PersonDto> personDtoList(@RequestParam(required = false) String email){
        return personDtoListMapper.personDtoListMapper(email);
    }

    @PostMapping("")
    public ResponseEntity<?> addPerson(@RequestBody CreatePerson createPerson){
            return personService.addPerson(createPerson);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @PatchMapping("/{id}/block")
    public PersonDto blockPersonDto(@PathVariable Long id){
        return blockPersonDtoMapper.blockPersonDtoMapper(id);
    }

    @PatchMapping("/{id}/unblock")
    public PersonDto unblockPersonDto(@PathVariable Long id){
        return unblockPersonDtoMapper.blockPersonDtoMapper(id);
    }

}
