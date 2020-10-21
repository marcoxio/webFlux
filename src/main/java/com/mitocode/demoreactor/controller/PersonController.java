package com.mitocode.demoreactor.controller;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.models.Person;
import com.mitocode.demoreactor.repository.IPersonaRepo;
import com.mitocode.demoreactor.repository.PersonRepoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private IPersonaRepo repo;

    @GetMapping
    public Flux<Person> listAll() {
        return repo.listAll();
    }

    @GetMapping("/{id}")
    public Mono<Person> listById(@PathVariable("id") Integer id) {
        return repo.listById(id);
    }

    @PostMapping
    public Mono<Person> create(@RequestBody Person per) {
        return repo.create(per);
    }

    @PutMapping
    public Mono<Person> update(@RequestBody Person per) {
        return repo.updated(per);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id) {
        return repo.listById(id)
                .flatMap(person -> repo.deleted(person.getIdPerson()));
        }

}
