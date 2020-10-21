package com.mitocode.demoreactor.repository;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.models.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepoImpl implements IPersonaRepo{

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    @Override
    public Mono<Person> create(Person per) {
        log.info(per.toString());
        return Mono.just(per);
    }

    @Override
    public Mono<Person> updated(Person per) {
        log.info(per.toString());
        return Mono.just(per);
    }

    @Override
    public Flux<Person> listAll() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito"));
        persons.add(new Person(2,"Code"));
        persons.add(new Person(3,"Jaime"));

        return Flux.fromIterable(persons);
    }

    @Override
    public Mono<Person> listById(Integer id) {
        return Mono.just(new Person(id,"Mito"));
    }

    @Override
    public Mono<Void> deleted(Integer id) {
        return Mono.empty();
    }
}
