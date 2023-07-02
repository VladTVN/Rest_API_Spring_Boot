package ru.tvn.springcourse.FirstRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tvn.springcourse.FirstRestApp.model.Person;
import ru.tvn.springcourse.FirstRestApp.service.PeopleService;
import ru.tvn.springcourse.FirstRestApp.util.PersonErrorResponse;
import ru.tvn.springcourse.FirstRestApp.util.PersonNotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {
    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping
    public List<Person> getPeople(){
        return peopleService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) throws PersonNotFoundException {
        return peopleService.findOne(id);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException exception){
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id was not found",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
