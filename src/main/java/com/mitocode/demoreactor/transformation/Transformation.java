package com.mitocode.demoreactor.transformation;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformation {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void map() {
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person(1,"Mito",27));
//        persons.add(new Person(2,"Code",28));
//        persons.add(new Person(3,"Jaime",29));
//
//        Flux.fromIterable(persons)
//                .map(person -> {
//                    person.setAge(person.getAge() + 10);
//                    return person;
//                })
//                .subscribe(person -> log.info(person.toString()));

        Flux<Integer> fx = Flux.range(0,10);
        Flux<Integer> fx2 = fx.map(x -> x +10);
        fx2.subscribe(x -> log.info("X : " + x));
    }

    public void flatMap() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .flatMap(p -> {
                    p.setAge(p.getAge() + 10);
                    return Mono.just(p);
                })
                .subscribe(person -> log.info(person.toString()));
    }

    public void groupBy() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .groupBy(Person::getIdPerson)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(x -> log.info(x.toString()));
    }
}
