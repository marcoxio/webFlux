package com.mitocode.demoreactor.error;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class ErrorOp {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void retry() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("One Error")))
                .retry(1)
                .doOnNext(x -> log.info(x.toString()))
                .subscribe();
    }

    public void errorReturn() {
        List<Person>persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("One Error")))
                .onErrorReturn(new Person(0, "XYZ", 99))
                .subscribe(person -> log.info(person.toString()));

    }

    public void errorResume() {
        List<Person>persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("One Error")))
                .onErrorResume(throwable -> Mono.just(new Person(0, "XYZ", 99)))
                .subscribe(person -> log.info(person.toString()));
    }

    public void errorMap() {
        List<Person>persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .concatWith(Flux.error(new RuntimeException("One Error")))
                .onErrorMap(throwable -> new InterruptedException(throwable.getMessage()))
                .subscribe(person -> log.info(person.toString()));
    }



}
