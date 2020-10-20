package com.mitocode.demoreactor.operators;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.model.Person;
import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creation {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void justFrom() {
        Mono.just(new Person(1,"Mito",29));
    }

    public void empty() {
        Mono.empty();
        Flux.empty();
        Observable.empty();
    }

    public void range() {
        Flux.range(0,3)
            .doOnNext(integer -> log.info("i : " + integer))
            .subscribe();
    }

    public void repeat() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));
        Flux.fromIterable(persons)
                .repeat(3)
                .subscribe(person -> log.info(person.toString()));

//        Mono.just(persons)
//                .repeat(3)
//                .subscribe(person -> log.info(person.toString()));
    }
}
