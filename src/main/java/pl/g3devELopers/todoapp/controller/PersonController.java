package pl.g3devELopers.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.g3devELopers.todoapp.dto.CreatePersonRequest;
import pl.g3devELopers.todoapp.model.PersonEntity;
import pl.g3devELopers.todoapp.service.PersonService;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/list")
    @ResponseBody
    public List<PersonEntity> getList(){
        return personService.getList();
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
