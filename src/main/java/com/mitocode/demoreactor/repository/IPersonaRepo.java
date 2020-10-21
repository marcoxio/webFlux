package com.mitocode.demoreactor.repository;

import com.mitocode.demoreactor.models.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonaRepo {

    Mono<Person> create(Person per);
    Mono<Person> updated(Person per);
    Flux<Person> listAll();
    Mono<Person> listById(Integer id);
    Mono<Void> deleted(Integer id);

}
