package com.mitocode.demoreactor.operators;

import com.mitocode.demoreactor.DemoReactorApplication;
import com.mitocode.demoreactor.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Matematico {

    private static final Logger log = LoggerFactory.getLogger(DemoReactorApplication.class);

    public void average() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .collect(Collectors.averagingInt(Person::getAge))
                .subscribe(person -> log.info(person.toString()));;
    }

    public void count() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .count()
                .subscribe(x -> log.info("Cantidad: " + x));

    }

    public void min() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .collect(Collectors.minBy(Comparator.comparing(Person::getAge)))
                .subscribe(p -> log.info(p.get().toString()));

    }

    public void max() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .collect(Collectors.maxBy(Comparator.comparing(Person::getAge)))
                .subscribe(p -> log.info(p.get().toString()));

    }

    public void sum() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .collect(Collectors.summingInt(Person::getAge))
                .subscribe(p -> log.info("Suma: " + p));

    }

    public void summarizing() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1,"Mito",27));
        persons.add(new Person(2,"Code",28));
        persons.add(new Person(3,"Jaime",29));

        Flux.fromIterable(persons)
                .collect(Collectors.summarizingInt(Person::getAge))
                .subscribe(p -> log.info("Resumen: " + p));

    }
}
